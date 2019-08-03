/*
 * Copyright 2014 Hieu Rocker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rockerhieu.emojicon;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rockerhieu.emojicon.emoji.Emojicon;
import com.yzx.im_demo.R;
import android.content.Context;
import android.text.Spannable;
import android.util.SparseIntArray;

/**
 * @author Hieu Rocker (rockerhieu@gmail.com)
 */
public final class EmojiconHandler {
    private EmojiconHandler() {
    }

    private static final SparseIntArray sEmojisMap = new SparseIntArray(846);
    private static final SparseIntArray sSoftbanksMap = new SparseIntArray(471);
    private static final HashMap<Integer, String> sResourceIdMap = new HashMap<Integer, String>();
    private static final HashMap<String, Integer> sImageIdMap = new HashMap<String, Integer>();
    private static final HashMap<String, Character> sImageIdChar = new HashMap<String, Character>();
    
    static {
        // People
        sEmojisMap.put(0x1f604, R.drawable.emoji_1f604);
        sEmojisMap.put(0x1f603, R.drawable.emoji_1f603);
        sEmojisMap.put(0x1f600, R.drawable.emoji_1f600);
        sEmojisMap.put(0x1f60a, R.drawable.emoji_1f60a);
        sEmojisMap.put(0x263a, R.drawable.emoji_263a);
        sEmojisMap.put(0x1f609, R.drawable.emoji_1f609);
        sEmojisMap.put(0x1f60d, R.drawable.emoji_1f60d);
        sEmojisMap.put(0x1f618, R.drawable.emoji_1f618);
        sEmojisMap.put(0x1f61a, R.drawable.emoji_1f61a);
        sEmojisMap.put(0x1f617, R.drawable.emoji_1f617);
        sEmojisMap.put(0x1f619, R.drawable.emoji_1f619);
        sEmojisMap.put(0x1f61c, R.drawable.emoji_1f61c);
        sEmojisMap.put(0x1f61d, R.drawable.emoji_1f61d);
        sEmojisMap.put(0x1f61b, R.drawable.emoji_1f61b);
        sEmojisMap.put(0x1f633, R.drawable.emoji_1f633);
        sEmojisMap.put(0x1f601, R.drawable.emoji_1f601);
        sEmojisMap.put(0x1f614, R.drawable.emoji_1f614);
        sEmojisMap.put(0x1f60c, R.drawable.emoji_1f60c);
        sEmojisMap.put(0x1f612, R.drawable.emoji_1f612);
        sEmojisMap.put(0x1f61e, R.drawable.emoji_1f61e);
        sEmojisMap.put(0x1f623, R.drawable.emoji_1f623);
        sEmojisMap.put(0x1f622, R.drawable.emoji_1f622);
        sEmojisMap.put(0x1f602, R.drawable.emoji_1f602);
        sEmojisMap.put(0x1f62d, R.drawable.emoji_1f62d);
        sEmojisMap.put(0x1f62a, R.drawable.emoji_1f62a);
        sEmojisMap.put(0x1f625, R.drawable.emoji_1f625);
        sEmojisMap.put(0x1f630, R.drawable.emoji_1f630);
        sEmojisMap.put(0x1f605, R.drawable.emoji_1f605);
        sEmojisMap.put(0x1f613, R.drawable.emoji_1f613);
        sEmojisMap.put(0x1f629, R.drawable.emoji_1f629);
        sEmojisMap.put(0x1f62b, R.drawable.emoji_1f62b);
        sEmojisMap.put(0x1f628, R.drawable.emoji_1f628);
        sEmojisMap.put(0x1f631, R.drawable.emoji_1f631);
        sEmojisMap.put(0x1f620, R.drawable.emoji_1f620);
        sEmojisMap.put(0x1f621, R.drawable.emoji_1f621);
        sEmojisMap.put(0x1f624, R.drawable.emoji_1f624);
        sEmojisMap.put(0x1f616, R.drawable.emoji_1f616);
        sEmojisMap.put(0x1f606, R.drawable.emoji_1f606);
        sEmojisMap.put(0x1f60b, R.drawable.emoji_1f60b);
        sEmojisMap.put(0x1f637, R.drawable.emoji_1f637);
        sEmojisMap.put(0x1f60e, R.drawable.emoji_1f60e);
        sEmojisMap.put(0x1f634, R.drawable.emoji_1f634);
        sEmojisMap.put(0x1f635, R.drawable.emoji_1f635);
        sEmojisMap.put(0x1f632, R.drawable.emoji_1f632);
        sEmojisMap.put(0x1f61f, R.drawable.emoji_1f61f);
        sEmojisMap.put(0x1f626, R.drawable.emoji_1f626);
        sEmojisMap.put(0x1f627, R.drawable.emoji_1f627);
        sEmojisMap.put(0x1f608, R.drawable.emoji_1f608);
        sEmojisMap.put(0x1f47f, R.drawable.emoji_1f47f);
        sEmojisMap.put(0x1f62e, R.drawable.emoji_1f62e);
        sEmojisMap.put(0x1f62c, R.drawable.emoji_1f62c);
        sEmojisMap.put(0x1f610, R.drawable.emoji_1f610);
        sEmojisMap.put(0x1f615, R.drawable.emoji_1f615);
        sEmojisMap.put(0x1f62f, R.drawable.emoji_1f62f);
        sEmojisMap.put(0x1f636, R.drawable.emoji_1f636);
        sEmojisMap.put(0x1f607, R.drawable.emoji_1f607);
        sEmojisMap.put(0x1f60f, R.drawable.emoji_1f60f);
        sEmojisMap.put(0x1f611, R.drawable.emoji_1f611);
        sEmojisMap.put(0x1f472, R.drawable.emoji_1f472);
        sEmojisMap.put(0x1f473, R.drawable.emoji_1f473);
        sEmojisMap.put(0x1f46e, R.drawable.emoji_1f46e);
        sEmojisMap.put(0x1f477, R.drawable.emoji_1f477);
        sEmojisMap.put(0x1f482, R.drawable.emoji_1f482);
        sEmojisMap.put(0x1f476, R.drawable.emoji_1f476);
        sEmojisMap.put(0x1f466, R.drawable.emoji_1f466);
        sEmojisMap.put(0x1f467, R.drawable.emoji_1f467);
        sEmojisMap.put(0x1f468, R.drawable.emoji_1f468);
        sEmojisMap.put(0x1f469, R.drawable.emoji_1f469);
        sEmojisMap.put(0x1f474, R.drawable.emoji_1f474);
        sEmojisMap.put(0x1f475, R.drawable.emoji_1f475);
        sEmojisMap.put(0x1f471, R.drawable.emoji_1f471);
        sEmojisMap.put(0x1f47c, R.drawable.emoji_1f47c);
        sEmojisMap.put(0x1f478, R.drawable.emoji_1f478);
        sEmojisMap.put(0x1f63a, R.drawable.emoji_1f63a);
        sEmojisMap.put(0x1f638, R.drawable.emoji_1f638);
        sEmojisMap.put(0x1f63b, R.drawable.emoji_1f63b);
        sEmojisMap.put(0x1f63d, R.drawable.emoji_1f63d);
        sEmojisMap.put(0x1f63c, R.drawable.emoji_1f63c);
        sEmojisMap.put(0x1f640, R.drawable.emoji_1f640);
        sEmojisMap.put(0x1f63f, R.drawable.emoji_1f63f);
        sEmojisMap.put(0x1f639, R.drawable.emoji_1f639);
        sEmojisMap.put(0x1f63e, R.drawable.emoji_1f63e);
        sEmojisMap.put(0x1f479, R.drawable.emoji_1f479);
        sEmojisMap.put(0x1f47a, R.drawable.emoji_1f47a);
        
        sResourceIdMap.put(R.drawable.emoji_1f604, ":smile:");
        sResourceIdMap.put(R.drawable.emoji_1f603, ":smiley:");
        sResourceIdMap.put(R.drawable.emoji_1f600, ":grinning:");
        sResourceIdMap.put(R.drawable.emoji_1f60a, ":blush:");
        sResourceIdMap.put(R.drawable.emoji_263a, ":relaxed:");
        sResourceIdMap.put(R.drawable.emoji_1f609, ":wink:");
        sResourceIdMap.put(R.drawable.emoji_1f60d, ":heart_eyes:");
        sResourceIdMap.put(R.drawable.emoji_1f618, ":kissing_heart:");
        sResourceIdMap.put(R.drawable.emoji_1f61a, ":kissing_closed_eyes:");
        sResourceIdMap.put(R.drawable.emoji_1f617, ":kissing:");
        sResourceIdMap.put(R.drawable.emoji_1f619, ":kissing_smiling_eyes:");
        sResourceIdMap.put(R.drawable.emoji_1f61c, ":stuck_out_tongue_winking_eye:");
        sResourceIdMap.put(R.drawable.emoji_1f61d, ":stuck_out_tongue_closed_eyes:");
        sResourceIdMap.put(R.drawable.emoji_1f61b, ":stuck_out_tongue:");
        sResourceIdMap.put(R.drawable.emoji_1f633, ":flushed:");
        sResourceIdMap.put(R.drawable.emoji_1f601, ":grin:");
        sResourceIdMap.put(R.drawable.emoji_1f614, ":pensive:");
        sResourceIdMap.put(R.drawable.emoji_1f60c, ":relieved:");
        sResourceIdMap.put(R.drawable.emoji_1f612, ":unamused:");
        sResourceIdMap.put(R.drawable.emoji_1f62b, ":tired_face:");
        sResourceIdMap.put(R.drawable.emoji_1f61e, ":disappointed:");
        sResourceIdMap.put(R.drawable.emoji_1f623, ":persevere:");
        sResourceIdMap.put(R.drawable.emoji_1f622, ":cry:");
        sResourceIdMap.put(R.drawable.emoji_1f602, ":joy:");
        sResourceIdMap.put(R.drawable.emoji_1f62d, ":sob:");
        sResourceIdMap.put(R.drawable.emoji_1f62a, ":sleepy:");
        sResourceIdMap.put(R.drawable.emoji_1f625, ":disappointed_relieved:");
        sResourceIdMap.put(R.drawable.emoji_1f630, ":cold_sweat:");
        sResourceIdMap.put(R.drawable.emoji_1f605, ":sweat_smile:");
        sResourceIdMap.put(R.drawable.emoji_1f613, ":sweat:");
        sResourceIdMap.put(R.drawable.emoji_1f629, ":weary:");
        sResourceIdMap.put(R.drawable.emoji_1f62b, ":tired_face:");
        sResourceIdMap.put(R.drawable.emoji_1f628, ":fearful:");
        sResourceIdMap.put(R.drawable.emoji_1f631, ":scream:");
        sResourceIdMap.put(R.drawable.emoji_1f620, ":angry:");
        sResourceIdMap.put(R.drawable.emoji_1f621, ":rage:");
        sResourceIdMap.put(R.drawable.emoji_1f624, ":triumph:");
        sResourceIdMap.put(R.drawable.emoji_1f616, ":confounded:");
        sResourceIdMap.put(R.drawable.emoji_1f606, ":satisfied:");
        sResourceIdMap.put(R.drawable.emoji_1f60b, ":yum:");
        sResourceIdMap.put(R.drawable.emoji_1f637, ":mask:");
        sResourceIdMap.put(R.drawable.emoji_1f60e, ":sunglasses:");
        sResourceIdMap.put(R.drawable.emoji_1f634, ":sleeping:");
        sResourceIdMap.put(R.drawable.emoji_1f635, ":dizzy_face:");
        sResourceIdMap.put(R.drawable.emoji_1f632, ":astonished:");
        sResourceIdMap.put(R.drawable.emoji_1f61f, ":worried:");
        sResourceIdMap.put(R.drawable.emoji_1f626, ":frowning:");
        sResourceIdMap.put(R.drawable.emoji_1f627, ":anguished:");
        sResourceIdMap.put(R.drawable.emoji_1f608, ":smiling_imp:");
        sResourceIdMap.put(R.drawable.emoji_1f47f, ":imp:");
        sResourceIdMap.put(R.drawable.emoji_1f62e, ":open_mouth:");
        sResourceIdMap.put(R.drawable.emoji_1f62c, ":grimacing:");
        sResourceIdMap.put(R.drawable.emoji_1f610, ":neutral_face:");
        sResourceIdMap.put(R.drawable.emoji_1f615, ":confused:");
        sResourceIdMap.put(R.drawable.emoji_1f62f, ":hushed:");
        sResourceIdMap.put(R.drawable.emoji_1f636, ":no_mouth:");
        sResourceIdMap.put(R.drawable.emoji_1f607, ":innocent:");      
        sResourceIdMap.put(R.drawable.emoji_1f60f, ":smirk:");
        sResourceIdMap.put(R.drawable.emoji_1f611, ":expressionless:");
        sResourceIdMap.put(R.drawable.emoji_1f472, ":man_with_gua_pi_mao:");
        sResourceIdMap.put(R.drawable.emoji_1f473, ":man_with_turban:");
        sResourceIdMap.put(R.drawable.emoji_1f46e, ":cop:");
        sResourceIdMap.put(R.drawable.emoji_1f477, ":construction_worker:");
        sResourceIdMap.put(R.drawable.emoji_1f482, ":guardsman:");
        sResourceIdMap.put(R.drawable.emoji_1f476, ":baby:");
        sResourceIdMap.put(R.drawable.emoji_1f466, ":boy:");
        sResourceIdMap.put(R.drawable.emoji_1f467, ":girl:");
        sResourceIdMap.put(R.drawable.emoji_1f468, ":man:");
        sResourceIdMap.put(R.drawable.emoji_1f469, ":woman:");
        sResourceIdMap.put(R.drawable.emoji_1f474, ":older_man:");
        sResourceIdMap.put(R.drawable.emoji_1f475, ":older_woman:");
        sResourceIdMap.put(R.drawable.emoji_1f471, ":person_with_blond_hair:");
        sResourceIdMap.put(R.drawable.emoji_1f47c, ":angel:");
        sResourceIdMap.put(R.drawable.emoji_1f478, ":princess:");
        sResourceIdMap.put(R.drawable.emoji_1f63a, ":smiley_cat:");
        sResourceIdMap.put(R.drawable.emoji_1f638, ":smile_cat:");
        sResourceIdMap.put(R.drawable.emoji_1f63b, ":heart_eyes_cat:");
        sResourceIdMap.put(R.drawable.emoji_1f63d, ":kissing_cat:");
        sResourceIdMap.put(R.drawable.emoji_1f63c, ":smirk_cat:");
        sResourceIdMap.put(R.drawable.emoji_1f640, ":scream_cat:");
        sResourceIdMap.put(R.drawable.emoji_1f63f, ":crying_cat_face:");
        sResourceIdMap.put(R.drawable.emoji_1f639, ":joy_cat:");
        sResourceIdMap.put(R.drawable.emoji_1f63e, ":pouting_cat:");
        sResourceIdMap.put(R.drawable.emoji_1f479, ":japanese_ogre:");
        sResourceIdMap.put(R.drawable.emoji_1f47a, ":japanese_goblin:");
        
        sImageIdMap.put("smile", 0x1f604);
        sImageIdMap.put("smiley", 0x1f603);
        sImageIdMap.put("grinning", 0x1f600);
        sImageIdMap.put("blush", 0x1f60a);
        sImageIdMap.put("wink", 0x1f609);
        sImageIdMap.put("heart_eyes", 0x1f60d);
        sImageIdMap.put("kissing_heart", 0x1f618);
        sImageIdMap.put("kissing_closed_eyes", 0x1f61a);
        sImageIdMap.put("kissing", 0x1f617);
        sImageIdMap.put("kissing_smiling_eyes", 0x1f619);
        sImageIdMap.put("stuck_out_tongue_winking_eye", 0x1f61c);
        sImageIdMap.put("stuck_out_tongue_closed_eyes", 0x1f61d);
        sImageIdMap.put("stuck_out_tongue", 0x1f61b);
        sImageIdMap.put("flushed", 0x1f633);
        sImageIdMap.put("grin", 0x1f601);
        sImageIdMap.put("pensive", 0x1f614);
        sImageIdMap.put("relieved", 0x1f60c);
        sImageIdMap.put("unamused", 0x1f612);
        sImageIdMap.put("disappointed", 0x1f61e);
        sImageIdMap.put("persevere", 0x1f623);
        sImageIdMap.put("cry", 0x1f622);
        sImageIdMap.put("joy", 0x1f602);
        sImageIdMap.put("sob", 0x1f62d);
        sImageIdMap.put("sleepy", 0x1f62a);
        sImageIdMap.put("disappointed_relieved", 0x1f625);
        sImageIdMap.put("cold_sweat", 0x1f630);
        sImageIdMap.put("sweat_smile", 0x1f605);
        sImageIdMap.put("sweat", 0x1f613);
        sImageIdMap.put("weary", 0x1f629);
        sImageIdMap.put("tired_face", 0x1f62b);
        sImageIdMap.put("fearful", 0x1f628);
        sImageIdMap.put("scream", 0x1f631);
        sImageIdMap.put("angry", 0x1f620);
        sImageIdMap.put("rage", 0x1f621);
        sImageIdMap.put("triumph", 0x1f624);
        sImageIdMap.put("confounded", 0x1f616);
        sImageIdMap.put("satisfied", 0x1f606);
        sImageIdMap.put("yum", 0x1f60b);
        sImageIdMap.put("mask", 0x1f637);
        sImageIdMap.put("sunglasses", 0x1f60e);
        sImageIdMap.put("sleeping", 0x1f634);
        sImageIdMap.put("dizzy_face", 0x1f635);
        sImageIdMap.put("astonished", 0x1f632);
        sImageIdMap.put("worried", 0x1f61f);
        sImageIdMap.put("frowning", 0x1f626);
        sImageIdMap.put("anguished", 0x1f627);
        sImageIdMap.put("smiling_imp", 0x1f608);
        sImageIdMap.put("imp", 0x1f47f);
        sImageIdMap.put("open_mouth", 0x1f62e);
        sImageIdMap.put("grimacing", 0x1f62c);
        sImageIdMap.put("neutral_face", 0x1f610);
        sImageIdMap.put("confused", 0x1f615);
        sImageIdMap.put("hushed", 0x1f62f);
        sImageIdMap.put("no_mouth", 0x1f636);
        sImageIdMap.put("innocent", 0x1f607);
        sImageIdMap.put("smirk", 0x1f60f);
        sImageIdMap.put("expressionless", 0x1f611);
        sImageIdMap.put("man_with_gua_pi_mao", 0x1f472);
        sImageIdMap.put("man_with_turban", 0x1f473);
        sImageIdMap.put("cop", 0x1f46e);
        sImageIdMap.put("construction_worker", 0x1f477);
        sImageIdMap.put("guardsman", 0x1f482);
        sImageIdMap.put("baby", 0x1f476);
        sImageIdMap.put("boy", 0x1f466);
        sImageIdMap.put("girl", 0x1f467);
        sImageIdMap.put("man", 0x1f468);
        sImageIdMap.put("woman", 0x1f469);
        sImageIdMap.put("older_man", 0x1f474);
        sImageIdMap.put("older_woman", 0x1f475);
        sImageIdMap.put("person_with_blond_hair", 0x1f471);
        sImageIdMap.put("angel", 0x1f47c);
        sImageIdMap.put("princess", 0x1f478);
        sImageIdMap.put("smiley_cat", 0x1f63a);
        sImageIdMap.put("smile_cat", 0x1f638);
        sImageIdMap.put("heart_eyes_cat", 0x1f63b);
        sImageIdMap.put("kissing_cat", 0x1f63d);
        sImageIdMap.put("smirk_cat", 0x1f63c);
        sImageIdMap.put("scream_cat", 0x1f640);
        sImageIdMap.put("crying_cat_face", 0x1f63f);
        sImageIdMap.put("joy_cat", 0x1f639);
        sImageIdMap.put("pouting_cat", 0x1f63e);
        sImageIdMap.put("japanese_ogre", 0x1f479);
        sImageIdMap.put("japanese_goblin", 0x1f47a);
 
        sImageIdChar.put("relaxed", (char) 0x263a);
    }

    
    private static boolean isSoftBankEmoji(char c) {
        return ((c >> 12) == 0xe);
    }

    private static int getEmojiResource(Context context, int codePoint) {
        return sEmojisMap.get(codePoint);
    }

    private static int getSoftbankEmojiResource(char c) {
        return sSoftbanksMap.get(c);
    }
    
    public static String getEmojiCode(int mResourceId) {
        return sResourceIdMap.get(mResourceId);
    }

    /**
     * Convert emoji characters of the given Spannable to the according emojicon.
     *
     * @param context
     * @param text
     * @param emojiSize
     */
    public static void addEmojis(Context context, Spannable text, int emojiSize) {
        int length = text.length();
        EmojiconSpan[] oldSpans = text.getSpans(0, length, EmojiconSpan.class);
        for (int i = 0; i < oldSpans.length; i++) {
            text.removeSpan(oldSpans[i]);
        }

        int skip;
        for (int i = 0; i < length; i += skip) {
            skip = 0;
            int icon = 0;
            char c = text.charAt(i);
            if (isSoftBankEmoji(c)) {
                icon = getSoftbankEmojiResource(c);
                skip = icon == 0 ? 0 : 1;
            }

            if (icon == 0) {
                int unicode = Character.codePointAt(text, i);
                skip = Character.charCount(unicode);

                if (unicode > 0xff) {
                    icon = getEmojiResource(context, unicode);
                }

                if (icon == 0 && i + skip < length) {
                    int followUnicode = Character.codePointAt(text, i + skip);
                    if (followUnicode == 0x20e3) {
                        int followSkip = Character.charCount(followUnicode);
                        switch (unicode) {
                            default:
                                followSkip = 0;
                                break;
                        }
                        skip += followSkip;
                    } else {
                        int followSkip = Character.charCount(followUnicode);
                        switch (unicode) {
                            default:
                                followSkip = 0;
                                break;
                        }
                        skip += followSkip;
                    }
                }
            }

            if (icon > 0) {
                text.setSpan(new EmojiconSpan(context, icon, emojiSize), i, i + skip, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
    }
    
    public static String conEmojis(String text) {
    	
    	String[] strarray = text.split(":");
    	if(strarray.length<2){
    		return text;
    	}
    	
    	String texttmp = text;
    	text = "";
    	Boolean beforeIsImg=false; 
    	for(int i=0;i<strarray.length;i++){
    		Boolean isImg=false; 
    		if(null != sImageIdMap.get(strarray[i])){
    			strarray[i] = Emojicon.newString(sImageIdMap.get(strarray[i]));
    			text = text+strarray[i];
    			isImg=true;
    			beforeIsImg=true;
    		}
    		
    		if(null != sImageIdChar.get(strarray[i])){
    			strarray[i] = Character.toString(sImageIdChar.get(strarray[i]));
    			text = text+strarray[i];
    			isImg=true;
    			beforeIsImg=true;
    		}
    		
    		if(!isImg){
    			if(i == 0){
    				text = text+strarray[i];
    			}else if(i == (strarray.length-1)){
    				//如果最后一个是":""::"":::"之类的，截取到最后的":::"之类字符串
    				String lastStr = texttmp.substring(texttmp.lastIndexOf(strarray[i])+strarray[i].length());
    				if(isSplite(lastStr)){
    					if(!"".equals(strarray[i-1])){
    						text = text+strarray[i]+lastStr;
    					}else{
    						text = text+":"+strarray[i]+lastStr;
    					}
    				}else{
//    					if(!"".equals(strarray[i-1])){
//    						text = text+strarray[i];
//    					}else{
//    						text = text+":"+strarray[i];
//    					}
    					if(beforeIsImg){
        					text = text+strarray[i];
        				}else{
        					text = text+":"+strarray[i];
        				}
    				}
    			}else{
    				if(beforeIsImg){
    					text = text+strarray[i];
    				}else{
    					text = text+":"+strarray[i];
    				}
    			}
    			beforeIsImg=false;
    		}
    	}
		return text;
    }
    /**
    * @Description 判断字符串是否是":""::"":::"这类的
    * @param text
    * @return	true表示匹配
    * @date 2016-1-6 上午11:08:08 
    * @author zhuqian  
    * @return boolean
     */
    private static boolean isSplite(String text){
    	Pattern pattern = Pattern.compile("^[:]{1,}$");
    	Matcher matcher = pattern.matcher(text);
    	return matcher.matches();
    }
}
