package com.yzx.mydefineview;

import java.util.ArrayList;
import java.util.List;
import com.yzx.im_demo.IMFriendListActivity;
import com.yzx.im_demo.R;
import com.yzxIM.data.CategoryId;
import com.yzxIM.data.db.ChatMessage;
import com.yzxIM.data.db.ConversationInfo;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.view.Window;

public class MessageDialog extends Dialog{

	private Context mcontext;
	private ConversationInfo conversationinfo=null;
	private ChatMessage msg=null;
	private IMessageHandlerListener listener;
	
	public MessageDialog(Context context, ConversationInfo info, ChatMessage message, int type) {
		super(context);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_message);
		mcontext = context;
		conversationinfo = info;
		msg = message;
		initViews();
		if(type==1 || type==2){
			findViewById(R.id.message_copy).setVisibility(View.GONE);
		}
	}

	private void initViews() {
		findViewById(R.id.message_copy).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ClipboardManager cm =(ClipboardManager) mcontext.getSystemService(Context.CLIPBOARD_SERVICE);
				cm.setText(msg.getContent());
				listener.msgHandle(msg, 2);
				dismiss();
			}
		});
		findViewById(R.id.message_delete).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				List<ChatMessage> msgs = new ArrayList<ChatMessage>();
				msgs.add(msg);
				if(conversationinfo.deleteMessages(msgs)){
					List<ChatMessage> chatmsgs = conversationinfo.getLastestMessages(0, 1);
					if(null!=chatmsgs&&chatmsgs.size()>0){
						ChatMessage chatmsg = (ChatMessage) chatmsgs.get(0);
						switch (chatmsg.getMsgType()) {
						case MSG_DATA_IMAGE:
							conversationinfo.setDraftMsg("图片");
							break;
						case MSG_DATA_VOICE:
							conversationinfo.setDraftMsg("语音:"+chatmsg.getContent());
							break;
						default:
							conversationinfo.setDraftMsg(chatmsg.getContent());
							break;
						}
	    			}else{
	    				conversationinfo.setDraftMsg("");
	    			}
					listener.msgHandle(msg, 1);
					dismiss();
				}
			}
		});
		findViewById(R.id.message_forward).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mcontext, IMFriendListActivity.class);
				Bundle data = new Bundle();
//				data.putParcelable("message", msg);
				data.putString("title", "选择好友");
				data.putInt("MsgType",msg.getMsgType().ordinal());
				data.putInt("CategoryId",CategoryId.PERSONAL.ordinal());
				data.putString("Content", msg.getContent());
				data.putString("Path", msg.getPath());
				intent.putExtras(data);
				mcontext.startActivity(intent);
				dismiss();
			}
		});
		findViewById(R.id.message_more).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});
	}
	public void setSendMsgListener(IMessageHandlerListener ml) {
		listener = ml;
	}
	public interface IMessageHandlerListener{
		void msgHandle(ChatMessage message, int type);
	}
	
}
