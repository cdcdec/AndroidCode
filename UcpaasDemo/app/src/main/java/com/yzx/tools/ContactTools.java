package com.yzx.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.text.TextUtils;
import com.yzx.im_demo.contact.CharacterParser;
import com.yzx.im_demo.contact.PinyinComparator;
import com.yzx.model.SortModel;
import com.yzxtcp.tools.CustomLog;

public class ContactTools {
	
	private static List<SortModel> SourceDateList=new ArrayList<SortModel>();
	private static CharacterParser characterParser = CharacterParser.getInstance();
	private static PinyinComparator pinyinComparator = new PinyinComparator();;
	
	/**联系人显示名称**/  
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;  
      
    /**电话号码**/  
    private static final int PHONES_NUMBER_INDEX = 1;  
      
    /**头像ID**/  
    private static final int PHONES_PHOTO_ID_INDEX = 2;
     
    /**联系人的ID**/  
    private static final int PHONES_CONTACT_ID_INDEX = 3;  
    
	private static final String[] PHONES_PROJECTION = new String[] {  
	       Phone.DISPLAY_NAME, Phone.NUMBER, Phone.PHOTO_ID, Phone.CONTACT_ID};
	
	public static List<SortModel> getSourceDateList(){
		return SourceDateList;
	}
	
	public static void initContacts(final Context mContext) {
		CustomLog.d("initContacts start");
		List<SortModel> list = getPhoneContacts(mContext);
		SourceDateList.clear();
		SourceDateList.addAll(list);
		Collections.sort(SourceDateList, pinyinComparator);
		CustomLog.d("initContacts finish");
	}
	
	  /**得到手机通讯录联系人信息**/  
    private static List<SortModel> getPhoneContacts(Context mContext) {
    	 List<SortModel> mSortList = new ArrayList<SortModel>();
    	 //添加3个摸默认账号号
    	 contactAddDefaultAccount(mSortList);
		 ContentResolver resolver = mContext.getContentResolver();  
		   
		 // 获取手机联系人  
		 Cursor phoneCursor = resolver.query(Phone.CONTENT_URI,PHONES_PROJECTION, null, null, null);  
		   
		 if (phoneCursor != null) {  
		     while (phoneCursor.moveToNext()) {  
		   
		    	SortModel sortModel = new SortModel();

				//得到手机号码  
				String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
				//当手机号码为空的或者为空字段 跳过当前循环  
				if (TextUtils.isEmpty(phoneNumber))  
					continue;
				 phoneNumber =  formatParentID(phoneNumber);//去掉电话号码内的+86 86
				//得到联系人名称
				String contactName = phoneCursor.getString(PHONES_DISPLAY_NAME_INDEX);  
		       
				//得到联系人ID  
				Long contactid = phoneCursor.getLong(PHONES_CONTACT_ID_INDEX);  
		   
				//得到联系人头像ID  
				//Long photoid = phoneCursor.getLong(PHONES_PHOTO_ID_INDEX);  
		       
				//得到联系人头像Bitamp  
				Bitmap contactPhoto = null;  
		   
				//photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的  
//				if(photoid > 0 ) {  
//					Uri uri =ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,contactid);  
//					InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(resolver, uri);  
//					contactPhoto = BitmapFactory.decodeStream(input);  
//				}

				sortModel.setName(contactName);
				sortModel.setId(phoneNumber);
				String pinyin = characterParser.getSelling(contactName);
				String sortString = null;
				if (!TextUtils.isEmpty(pinyin) && pinyin.length() >= 1){
				    sortString = pinyin.substring(0, 1).toUpperCase();
				}
				else {
				    sortString = "";
				}

				if (sortString.matches("[A-Z]")) {
					sortModel.setSortLetters(sortString.toUpperCase());
				} else {
					sortModel.setSortLetters("#");
				}
				sortModel.setBitmap(contactPhoto);
				mSortList.add(sortModel);
		     }  
		     phoneCursor.close();  
		 }  
		 return mSortList;
    }  
    
    private List<SortModel> filledData(String[] date) {
		List<SortModel> mSortList = new ArrayList<SortModel>();

		for (int i = 0; i < date.length; i++) {
			SortModel sortModel = new SortModel();
			sortModel.setName(date[i]);

			String pinyin = characterParser.getSelling(date[i]);
			String sortString = pinyin.substring(0, 1).toUpperCase();

			if (sortString.matches("[A-Z]")) {
				sortModel.setSortLetters(sortString.toUpperCase());
			} else {
				sortModel.setSortLetters("#");
			}

			mSortList.add(sortModel);
		}
		return mSortList;

	}

	/**
	 * ListView
	 * 
	 * @param filterStr
	 */
	private List<SortModel> filterData(String filterStr) {
		List<SortModel> filterDateList = new ArrayList<SortModel>();

		if (TextUtils.isEmpty(filterStr)) {
			filterDateList = SourceDateList;
		} else {
			filterDateList.clear();
			for (SortModel sortModel : SourceDateList) {
				String name = sortModel.getName();
				if (name.indexOf(filterStr.toString()) != -1
						|| characterParser.getSelling(name).startsWith(
								filterStr.toString())) {
					filterDateList.add(sortModel);
				}
			}
		}

		Collections.sort(filterDateList, pinyinComparator);
		return filterDateList;
	}
	
	
	private static void contactAddDefaultAccount(List<SortModel> mSortList){
		String[] contactName = new String[]{"测试账号1","测试账号2","测试账号3","测试账号4"};
		String[] phoneNumber = new String[]{"18687654321", "18687654322", "18687654323","smt0209"};
		for(int i = 0; i < contactName.length; i++){
			SortModel sortModel = new SortModel();
			sortModel.setName(contactName[i]);
			sortModel.setId(phoneNumber[i]);
			String pinyin = characterParser.getSelling(contactName[i]);
			String sortString = pinyin.substring(0, 1).toUpperCase();
			sortModel.setSortLetters("*");
			/*if (sortString.matches("[A-Z]")) {
				sortModel.setSortLetters(sortString.toUpperCase());
			} else {
				sortModel.setSortLetters("#");
			}*/
			mSortList.add(sortModel);
		}
	}
	
	public static String getConTitle(String id){
		if(SourceDateList == null || SourceDateList.size() == 0){
			return "";
		}
		String result = "";
		for(SortModel item : SourceDateList){
			if(item.getId().equals(id)){
				result = item.getName();
			}
		}
		return result;
	}

	/**
	 *
	 * @author zhangbin
	 * @2016-1-31
	 * @param phoneNum
	 * @descript:去掉+86或86
	 */
	private static String formatParentID(String phoneNum){
		if(phoneNum.startsWith("+86")){
			phoneNum = phoneNum.substring(3, phoneNum.length());
		}else if(phoneNum.startsWith("86")){
			phoneNum = phoneNum.substring(2, phoneNum.length());
		}
		return phoneNum;
	}
}
