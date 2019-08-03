package com.yzx.mydefineview;

import java.util.ArrayList;
import java.util.List;
import com.yzx.im_demo.R;
import com.yzx.mydefineview.MessagePopView.OnMessageHandler;
import com.yzxIM.data.db.ChatMessage;
import com.yzxIM.data.db.ConversationInfo;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * 消息操作pop
 * 
 * @author zhuqian
 * 
 */
public class MessagePop extends PopupWindow implements OnMessageHandler {

	private View contentView;
	private MessagePopView messagePopView;
	private IMessageHandlerListener mListener;
	private ChatMessage msg;
	private Context context;
	private ConversationInfo info;

	private String text;

	public MessagePop(Context context, IMessageHandlerListener mListener,
			ConversationInfo info, ChatMessage msg, int type) {
		super(context);

		contentView = LayoutInflater.from(context).inflate(
				R.layout.pop_message, null);
		messagePopView = (MessagePopView) contentView
				.findViewById(R.id.msg_pop);
		this.info = info;
		this.context = context;
		this.mListener = mListener;
		this.msg = msg;

		messagePopView.setMessageHandler(this);
		messagePopView.setOperateStyle(type);

		setWidth(messagePopView.getWidthAndHeight()[0]);
		setHeight(messagePopView.getWidthAndHeight()[1]);
		setContentView(contentView);
		setFocusable(true);
		setOutsideTouchable(true);
		setTouchable(true);
		setBackgroundDrawable(new ColorDrawable(0));
	}

	public void onHandleMessage(int type) {
		if(mListener != null){
			if(type == 0){
				//复制
				ClipboardManager cm =(ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
				if(TextUtils.isEmpty(text)){
					cm.setText(msg.getContent());
				}else{
					cm.setText(text);
				}
				Toast.makeText(context, "已复制", 0).show();
				dismiss();
			}else if(type == 1){
				List<ChatMessage> msgs = new ArrayList<ChatMessage>();
				msgs.add(msg);
				if(info.deleteMessages(msgs)){
					List<ChatMessage> chatmsgs = info.getLastestMessages(0, 1);
					if(null!=chatmsgs&&chatmsgs.size()>0){
						ChatMessage chatmsg = (ChatMessage) chatmsgs.get(0);
						switch (chatmsg.getMsgType()) {
						case MSG_DATA_IMAGE:
							info.setDraftMsg("[图片]");
							break;
						case MSG_DATA_VOICE:
							info.setDraftMsg("[语音:"+chatmsg.getContent()+"秒]");
							break;
						case MSG_DATA_LOCALMAP:
							info.setDraftMsg("[位置]");
							break;
						case MSG_DATA_CUSTOMMSG:
							info.setDraftMsg("[自定义消息]");
							break;
						default:
							info.setDraftMsg(chatmsg.getContent());
							break;
						}
	    			}else{
	    				info.setDraftMsg("");
	    			}
					mListener.msgHandle(msg);
					dismiss();
				}
			}
		}
	}

	public interface IMessageHandlerListener {
		void msgHandle(ChatMessage msg);
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getWidth() {
		return messagePopView.getWidthAndHeight()[0];
	}
}
