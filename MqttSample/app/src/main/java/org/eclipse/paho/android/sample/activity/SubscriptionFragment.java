package org.eclipse.paho.android.sample.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;

import org.eclipse.paho.android.sample.R;
import org.eclipse.paho.android.sample.model.Subscription;
import org.eclipse.paho.android.sample.components.SubscriptionListItemAdapter;
import org.eclipse.paho.android.sample.internal.Connections;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.ArrayList;
import java.util.Map;


public class SubscriptionFragment extends Fragment {

    private int temp_qos_value = 0;
    // --Commented out by Inspection (12/10/2016, 10:22):ListView subscriptionListView;

    private ArrayList<Subscription> subscriptions;

    private Connection connection;

    public SubscriptionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle  = this.getArguments();
        String connectionHandle = bundle.getString(ActivityConstants.CONNECTION_KEY);
        Map<String, Connection> connections = Connections.getInstance(this.getActivity())
                .getConnections();
        connection = connections.get(connectionHandle);
        subscriptions = connection.getSubscriptions();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_subscriptions, container, false);
        Button subscribeButton = (Button) rootView.findViewById(R.id.subscribe_button);

        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });

        ListView subscriptionListView = (ListView) rootView.findViewById(R.id.subscription_list_view);
        SubscriptionListItemAdapter adapter = new SubscriptionListItemAdapter(this.getActivity(), subscriptions);

        adapter.addOnUnsubscribeListner(new SubscriptionListItemAdapter.OnUnsubscribeListner() {
            @Override
            public void onUnsubscribe(Subscription subscription) {
                try {
                    connection.unsubscribe(subscription);
                    System.out.println("Unsubscribed from: " + subscription.toString());
                } catch (MqttException ex) {
                    System.out.println("Failed to unsubscribe from " + subscription.toString() + ". " + ex.getMessage());
                }
            }
        });
        subscriptionListView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return rootView;
    }

    private void showInputDialog(){
        LayoutInflater layoutInflater =  (LayoutInflater) this.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("InflateParams") View promptView = layoutInflater.inflate(R.layout.subscription_dialog, null);
        final EditText topicText = (EditText) promptView.findViewById(R.id.subscription_topic_edit_text);

        final Spinner qos = (Spinner) promptView.findViewById(R.id.subscription_qos_spinner);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.qos_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qos.setAdapter(adapter);
        qos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                temp_qos_value = Integer.parseInt(getResources().getStringArray(R.array.qos_options)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final Switch notifySwitch = (Switch) promptView.findViewById(R.id.show_notifications_switch);




        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(((AppCompatActivity) getActivity()).getSupportActionBar().getThemedContext());
        alertDialogBuilder.setView(promptView);
        alertDialogBuilder.setCancelable(true).setPositiveButton(R.string.subscribe_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                String topic = topicText.getText().toString();

                Subscription subscription = new Subscription(topic, temp_qos_value, connection.handle(), notifySwitch.isChecked());
                subscriptions.add(subscription);
                try {
                    connection.addNewSubscription(subscription);

                } catch (MqttException ex) {
                    System.out.println("MqttException whilst subscribing: " + ex.getMessage());
                }
                adapter.notifyDataSetChanged();
            }

        }).setNegativeButton(R.string.subscribe_cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alert =  alertDialogBuilder.create();
        alert.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        alert.show();
    }

}