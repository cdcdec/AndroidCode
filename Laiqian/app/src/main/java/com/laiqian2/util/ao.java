package com.laiqian.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;

public class ao {
  public static final char[] dFm = { 
      -27073, '哎', '安', -32594, '凹', '八', '挀', '扳', -28506, '勹', 
      -27070, '奔', '伻', '屄', -28743, '灬', '憋', '汃', '冫', '癶', 
      '峬', '嚓', '偲', '参', '仓', '撡', '冊', '嵾', '曽', '曾', 
      '層', '叉', -32122, -28737, '伥', '抄', -28826, '抻', '沈', '沉', 
      -27081, '吃', '充', '抽', '出', '欻', '揣', '巛', '刅', '吹', 
      '旾', -28620, '呲', '匆', '凑', '粗', '汆', '崔', -28504, '搓', 
      '咑', '呆', '丹', '当', '刀', '嘚', '扥', '灯', '氐', '嗲', 
      '甸', '刁', '爹', '丁', '丟', '东', '吺', '厾', -32751, -30360, 
      '吨', '多', '妸', -29706, '奀', -26715, '儿', '发', '帆', '匚', 
      -26402, '分', '丰', -30331, '仏', '紑', '伕', '旮', '侅', '甘', 
      '冈', '皋', '戈', '给', '根', '刯', '工', '勾', '估', '瓜', 
      '乖', '关', '光', '归', '丨', '呙', '哈', '咍', '佄', '夯', 
      -31968, -29757, -24878, '拫', '亨', '噷', '叿', -24767, '乯', -32079, 
      '怀', '犿', '巟', '灰', '昏', '吙', '丌', '加', '戋', '江', 
      -32131, -27082, '巾', '坕', '冂', '丩', '凥', '姢', '噘', '军', 
      '咔', '开', '刊', '忼', '尻', '匼', -32626, '劥', '空', '抠', 
      '扝', '夸', -31569, '宽', '匡', '亏', '坤', '扩', '垃', '来', 
      '兰', '啷', '捞', -32629, '勒', '崚', '刕', '俩', '奁', -32145, 
      '撩', '列', '拎', '刢', '溜', '囖', -24679, '瞜', '噜', '娈', 
      '畧', '抡', '罗', '呣', '妈', '埋', '嫚', '牤', '猫', '么', 
      '呅', -27160, '甿', '咪', '宀', '喵', '乜', '民', '名', -29652, 
      '摸', '哞', '毪', '嗯', '拏', -32439, '囡', '囔', '孬', '疒', 
      '娞', '恁', -32515, '妮', '拈', '嬢', -25057, '捏', '囜', '宁', 
      '妞', '农', '羺', '奴', '奻', '疟', -24895, -28467, '喔', -29772, 
      '妑', '拍', '眅', '乓', '抛', '呸', '喷', '匉', '丕', '囨', 
      '剽', '氕', '姘', '乒', -27509, '剖', '仆', '七', '掐', '千', 
      '呛', '悄', '癿', '亲', '狅', -32114, '丘', '区', '峑', '缺', 
      '夋', '呥', '穣', '娆', '惹', '人', '扔', '日', -31944, '厹', 
      -28518, '挼', '堧', '婑', '瞤', '捼', '仨', '毢', '三', '桒', 
      '掻', -27222, '森', '僧', '杀', '筛', '山', '伤', '弰', '奢', 
      '申', -31848, '敒', '升', '尸', '収', '书', '刷', -30608, -27159, 
      '双', -29695, '吮', -29708, '厶', '忪', '捜', -32049, '狻', '夊', 
      '孙', '唆', '他', '囼', '坍', '汤', '夲', '忑', '熥', '剔', 
      '天', '旫', '帖', '厅', '囲', '偷', '凸', '湍', '推', '吞', 
      '乇', '穵', '歪', '弯', '尣', '危', '昷', '翁', '挝', '乌', 
      '夕', -31118, '仚', '乡', '灱', '些', '心', '星', '凶', '休', 
      '吁', '吅', '削', '坃', '丫', '恹', '央', '幺', '倻', '一', 
      '囙', '应', '哟', '佣', '优', '扜', '囦', '曰', '晕', '筠', 
      '筼', '帀', '災', '兂', '匨', '傮', '则', -29380, '怎', '増', 
      '扎', '捚', '沾', '张', -27265, -27273, '佋', -30969, -29410, '争', 
      '之', '峙', '庢', '中', '州', '朱', '抓', '拽', '专', '妆', 
      -26951, '宒', '卓', '乲', '宗', -28487, '租', -27461, '厜', '尊', 
      '昨', '兙', -24637, -24636 };
  
  public static final byte[][] dFn;
  
  private static final Collator dFo;
  
  private static ao dFp;
  
  private final boolean dFq;
  
  StringBuilder dFr;
  
  StringBuilder dFs;
  
  StringBuilder dFt;
  
  static  {
    byte[] arrayOfByte1 = { 65, 0, 0, 0, 0, 0 };
    byte[] arrayOfByte2 = { 65, 78, 0, 0, 0, 0 };
    byte[] arrayOfByte3 = { 65, 78, 71, 0, 0, 0 };
    byte[] arrayOfByte4 = { 65, 79, 0, 0, 0, 0 };
    byte[] arrayOfByte5 = { 66, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte6 = { 66, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte7 = { 66, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte8 = { 66, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte9 = { 66, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte10 = { 66, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte11 = { 67, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte12 = { 67, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte13 = { 67, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte14 = { 67, 72, 65, 78, 0, 0 };
    byte[] arrayOfByte15 = { 67, 72, 65, 78, 71, 0 };
    byte[] arrayOfByte16 = { 67, 72, 73, 0, 0, 0 };
    byte[] arrayOfByte17 = { 67, 72, 85, 65, 0, 0 };
    byte[] arrayOfByte18 = { 67, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte19 = { 67, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte20 = { 68, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte21 = { 68, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte22 = { 68, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte23 = { 68, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte24 = { 68, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte25 = { 68, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte26 = { 68, 85, 73, 0, 0, 0 };
    byte[] arrayOfByte27 = { 69, 0, 0, 0, 0, 0 };
    byte[] arrayOfByte28 = { 69, 78, 0, 0, 0, 0 };
    byte[] arrayOfByte29 = { 70, 79, 0, 0, 0, 0 };
    byte[] arrayOfByte30 = { 71, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte31 = { 71, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte32 = { 71, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte33 = { 71, 85, 65, 73, 0, 0 };
    byte[] arrayOfByte34 = { 71, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte35 = { 71, 85, 73, 0, 0, 0 };
    byte[] arrayOfByte36 = { 71, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte37 = { 72, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte38 = { 72, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte39 = { 72, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte40 = { 72, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte41 = { 72, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte42 = { 74, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte43 = { 74, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte44 = { 74, 73, 79, 78, 71, 0 };
    byte[] arrayOfByte45 = { 74, 73, 85, 0, 0, 0 };
    byte[] arrayOfByte46 = { 75, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte47 = { 75, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte48 = { 75, 85, 65, 73, 0, 0 };
    byte[] arrayOfByte49 = { 75, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte50 = { 76, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte51 = { 76, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte52 = { 76, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte53 = { 76, 73, 65, 0, 0, 0 };
    byte[] arrayOfByte54 = { 76, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte55 = { 76, 73, 65, 78, 71, 0 };
    byte[] arrayOfByte56 = { 76, 73, 85, 0, 0, 0 };
    byte[] arrayOfByte57 = { 76, 79, 0, 0, 0, 0 };
    byte[] arrayOfByte58 = { 76, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte59 = { 76, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte60 = { 76, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte61 = { 77, 0, 0, 0, 0, 0 };
    byte[] arrayOfByte62 = { 77, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte63 = { 77, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte64 = { 77, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte65 = { 77, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte66 = { 78, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte67 = { 78, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte68 = { 78, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte69 = { 78, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte70 = { 78, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte71 = { 78, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte72 = { 78, 73, 65, 78, 71, 0 };
    byte[] arrayOfByte73 = { 78, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte74 = { 78, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte75 = { 78, 85, 69, 0, 0, 0 };
    byte[] arrayOfByte76 = { 78, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte77 = { 78, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte78 = { 80, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte79 = { 80, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte80 = { 80, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte81 = { 80, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte82 = { 80, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte83 = { 81, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte84 = { 81, 73, 79, 78, 71, 0 };
    byte[] arrayOfByte85 = { 81, 73, 85, 0, 0, 0 };
    byte[] arrayOfByte86 = { 81, 85, 69, 0, 0, 0 };
    byte[] arrayOfByte87 = { 81, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte88 = { 82, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte89 = { 82, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte90 = { 82, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte91 = { 82, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte92 = { 82, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte93 = { 82, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte94 = { 82, 85, 73, 0, 0, 0 };
    byte[] arrayOfByte95 = { 82, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte96 = { 82, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte97 = { 83, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte98 = { 83, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte99 = { 83, 72, 65, 73, 0, 0 };
    byte[] arrayOfByte100 = { 83, 72, 65, 78, 71, 0 };
    byte[] arrayOfByte101 = { 88, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte102 = { 83, 72, 69, 78, 0, 0 };
    byte[] arrayOfByte103 = { 83, 72, 79, 85, 0, 0 };
    byte[] arrayOfByte104 = { 83, 72, 85, 0, 0, 0 };
    byte[] arrayOfByte105 = { 83, 72, 85, 65, 0, 0 };
    byte[] arrayOfByte106 = { 83, 72, 85, 65, 78, 0 };
    byte[] arrayOfByte107 = { 83, 72, 85, 79, 0, 0 };
    byte[] arrayOfByte108 = { 83, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte109 = { 83, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte110 = { 83, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte111 = { 84, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte112 = { 84, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte113 = { 84, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte114 = { 84, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte115 = { 84, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte116 = { 84, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte117 = { 87, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte118 = { 87, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte119 = { 87, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte120 = { 87, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte121 = { 87, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte122 = { 88, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte123 = { 88, 73, 65, 0, 0, 0 };
    byte[] arrayOfByte124 = { 88, 73, 65, 78, 71, 0 };
    byte[] arrayOfByte125 = { 88, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte126 = { 88, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte127 = { 88, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte128 = { 88, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte129 = { 88, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte130 = { 89, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte131 = { 89, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte132 = { 89, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte133 = { 89, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte134 = { 89, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte135 = { 74, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte136 = { 90, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte137 = { 90, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte138 = { 90, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte139 = { 90, 72, 65, 0, 0, 0 };
    byte[] arrayOfByte140 = { 67, 72, 65, 78, 71, 0 };
    byte[] arrayOfByte141 = { 90, 72, 73, 0, 0, 0 };
    byte[] arrayOfByte142 = { 90, 72, 79, 78, 71, 0 };
    byte[] arrayOfByte143 = { 90, 72, 85, 65, 73, 0 };
    byte[] arrayOfByte144 = { 90, 72, 85, 65, 78, 0 };
    byte[] arrayOfByte145 = { 90, 72, 85, 73, 0, 0 };
    byte[] arrayOfByte146 = { 90, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte147 = { 90, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte148 = { 83, 72, 65, 78, 0, 0 };
    byte[] arrayOfByte149 = { 0, 0, 0, 0, 0, 0 };
    dFn = new byte[][] { 
        arrayOfByte1, { 65, 73, 0, 0, 0, 0 }, arrayOfByte2, arrayOfByte3, arrayOfByte4, { 66, 65, 0, 0, 0, 0 }, arrayOfByte5, arrayOfByte6, { 66, 65, 78, 71, 0, 0 }, arrayOfByte7, 
        arrayOfByte8, { 66, 69, 78, 0, 0, 0 }, arrayOfByte9, { 66, 73, 0, 0, 0, 0 }, { 66, 73, 65, 78, 0, 0 }, { 66, 73, 65, 79, 0, 0 }, { 66, 73, 69, 0, 0, 0 }, arrayOfByte10, { 66, 73, 78, 71, 0, 0 }, { 66, 79, 0, 0, 0, 0 }, 
        { 66, 85, 0, 0, 0, 0 }, { 67, 65, 0, 0, 0, 0 }, { 67, 65, 73, 0, 0, 0 }, { 67, 65, 78, 0, 0, 0 }, arrayOfByte11, arrayOfByte12, { 67, 69, 0, 0, 0, 0 }, { 67, 69, 78, 0, 0, 0 }, arrayOfByte13, { 90, 69, 78, 71, 0, 0 }, 
        { 67, 69, 78, 71, 0, 0 }, { 67, 72, 65, 0, 0, 0 }, { 67, 72, 65, 73, 0, 0 }, arrayOfByte14, arrayOfByte15, { 67, 72, 65, 79, 0, 0 }, { 67, 72, 69, 0, 0, 0 }, { 67, 72, 69, 78, 0, 0 }, { 83, 72, 69, 78, 0, 0 }, { 67, 72, 69, 78, 0, 0 }, 
        { 67, 72, 69, 78, 71, 0 }, arrayOfByte16, { 67, 72, 79, 78, 71, 0 }, { 67, 72, 79, 85, 0, 0 }, { 67, 72, 85, 0, 0, 0 }, arrayOfByte17, { 67, 72, 85, 65, 73, 0 }, { 67, 72, 85, 65, 78, 0 }, { 67, 72, 85, 65, 78, 71 }, { 67, 72, 85, 73, 0, 0 }, 
        { 67, 72, 85, 78, 0, 0 }, { 67, 72, 85, 79, 0, 0 }, arrayOfByte18, { 67, 79, 78, 71, 0, 0 }, { 67, 79, 85, 0, 0, 0 }, { 67, 85, 0, 0, 0, 0 }, { 67, 85, 65, 78, 0, 0 }, { 67, 85, 73, 0, 0, 0 }, arrayOfByte19, { 67, 85, 79, 0, 0, 0 }, 
        arrayOfByte20, { 68, 65, 73, 0, 0, 0 }, arrayOfByte21, { 68, 65, 78, 71, 0, 0 }, { 68, 65, 79, 0, 0, 0 }, arrayOfByte22, { 68, 69, 78, 0, 0, 0 }, { 68, 69, 78, 71, 0, 0 }, arrayOfByte23, { 68, 73, 65, 0, 0, 0 }, 
        { 68, 73, 65, 78, 0, 0 }, { 68, 73, 65, 79, 0, 0 }, { 68, 73, 69, 0, 0, 0 }, { 68, 73, 78, 71, 0, 0 }, { 68, 73, 85, 0, 0, 0 }, arrayOfByte24, arrayOfByte25, { 68, 85, 0, 0, 0, 0 }, { 68, 85, 65, 78, 0, 0 }, arrayOfByte26, 
        { 68, 85, 78, 0, 0, 0 }, { 68, 85, 79, 0, 0, 0 }, arrayOfByte27, { 69, 73, 0, 0, 0, 0 }, arrayOfByte28, { 69, 78, 71, 0, 0, 0 }, { 69, 82, 0, 0, 0, 0 }, { 70, 65, 0, 0, 0, 0 }, { 70, 65, 78, 0, 0, 0 }, { 70, 65, 78, 71, 0, 0 }, 
        { 70, 69, 73, 0, 0, 0 }, { 70, 69, 78, 0, 0, 0 }, { 70, 69, 78, 71, 0, 0 }, { 70, 73, 65, 79, 0, 0 }, arrayOfByte29, { 70, 79, 85, 0, 0, 0 }, { 70, 85, 0, 0, 0, 0 }, { 71, 65, 0, 0, 0, 0 }, { 71, 65, 73, 0, 0, 0 }, { 71, 65, 78, 0, 0, 0 }, 
        { 71, 65, 78, 71, 0, 0 }, arrayOfByte30, { 71, 69, 0, 0, 0, 0 }, arrayOfByte31, { 71, 69, 78, 0, 0, 0 }, arrayOfByte32, { 71, 79, 78, 71, 0, 0 }, { 71, 79, 85, 0, 0, 0 }, { 71, 85, 0, 0, 0, 0 }, { 71, 85, 65, 0, 0, 0 }, 
        arrayOfByte33, arrayOfByte34, { 71, 85, 65, 78, 71, 0 }, arrayOfByte35, arrayOfByte36, { 71, 85, 79, 0, 0, 0 }, arrayOfByte37, { 72, 65, 73, 0, 0, 0 }, { 72, 65, 78, 0, 0, 0 }, arrayOfByte38, 
        { 72, 65, 79, 0, 0, 0 }, arrayOfByte39, arrayOfByte40, { 72, 69, 78, 0, 0, 0 }, arrayOfByte41, { 72, 77, 0, 0, 0, 0 }, { 72, 79, 78, 71, 0, 0 }, { 72, 79, 85, 0, 0, 0 }, { 72, 85, 0, 0, 0, 0 }, { 72, 85, 65, 0, 0, 0 }, 
        { 72, 85, 65, 73, 0, 0 }, { 72, 85, 65, 78, 0, 0 }, { 72, 85, 65, 78, 71, 0 }, { 72, 85, 73, 0, 0, 0 }, { 72, 85, 78, 0, 0, 0 }, { 72, 85, 79, 0, 0, 0 }, { 74, 73, 0, 0, 0, 0 }, { 74, 73, 65, 0, 0, 0 }, { 74, 73, 65, 78, 0, 0 }, { 74, 73, 65, 78, 71, 0 }, 
        arrayOfByte42, arrayOfByte43, { 74, 73, 78, 0, 0, 0 }, { 74, 73, 78, 71, 0, 0 }, arrayOfByte44, arrayOfByte45, { 74, 85, 0, 0, 0, 0 }, { 74, 85, 65, 78, 0, 0 }, { 74, 85, 69, 0, 0, 0 }, { 74, 85, 78, 0, 0, 0 }, 
        { 75, 65, 0, 0, 0, 0 }, arrayOfByte46, { 75, 65, 78, 0, 0, 0 }, arrayOfByte47, { 75, 65, 79, 0, 0, 0 }, { 75, 69, 0, 0, 0, 0 }, { 75, 69, 78, 0, 0, 0 }, { 75, 69, 78, 71, 0, 0 }, { 75, 79, 78, 71, 0, 0 }, { 75, 79, 85, 0, 0, 0 }, 
        { 75, 85, 0, 0, 0, 0 }, { 75, 85, 65, 0, 0, 0 }, arrayOfByte48, arrayOfByte49, { 75, 85, 65, 78, 71, 0 }, { 75, 85, 73, 0, 0, 0 }, { 75, 85, 78, 0, 0, 0 }, { 75, 85, 79, 0, 0, 0 }, { 76, 65, 0, 0, 0, 0 }, arrayOfByte50, 
        { 76, 65, 78, 0, 0, 0 }, arrayOfByte51, arrayOfByte52, { 76, 69, 0, 0, 0, 0 }, { 76, 69, 73, 0, 0, 0 }, { 76, 69, 78, 71, 0, 0 }, { 76, 73, 0, 0, 0, 0 }, arrayOfByte53, arrayOfByte54, arrayOfByte55, 
        { 76, 73, 65, 79, 0, 0 }, { 76, 73, 69, 0, 0, 0 }, { 76, 73, 78, 0, 0, 0 }, { 76, 73, 78, 71, 0, 0 }, arrayOfByte56, arrayOfByte57, { 76, 79, 78, 71, 0, 0 }, { 76, 79, 85, 0, 0, 0 }, arrayOfByte58, arrayOfByte59, 
        { 76, 85, 69, 0, 0, 0 }, { 76, 85, 78, 0, 0, 0 }, arrayOfByte60, arrayOfByte61, { 77, 65, 0, 0, 0, 0 }, arrayOfByte62, { 77, 65, 78, 0, 0, 0 }, { 77, 65, 78, 71, 0, 0 }, { 77, 65, 79, 0, 0, 0 }, { 77, 69, 0, 0, 0, 0 }, 
        { 77, 69, 73, 0, 0, 0 }, { 77, 69, 78, 0, 0, 0 }, arrayOfByte63, { 77, 73, 0, 0, 0, 0 }, { 77, 73, 65, 78, 0, 0 }, arrayOfByte64, { 77, 73, 69, 0, 0, 0 }, arrayOfByte65, { 77, 73, 78, 71, 0, 0 }, { 77, 73, 85, 0, 0, 0 }, 
        { 77, 79, 0, 0, 0, 0 }, { 77, 79, 85, 0, 0, 0 }, { 77, 85, 0, 0, 0, 0 }, { 78, 0, 0, 0, 0, 0 }, arrayOfByte66, arrayOfByte67, arrayOfByte68, { 78, 65, 78, 71, 0, 0 }, arrayOfByte69, arrayOfByte70, 
        arrayOfByte71, { 78, 69, 78, 0, 0, 0 }, { 78, 69, 78, 71, 0, 0 }, { 78, 73, 0, 0, 0, 0 }, { 78, 73, 65, 78, 0, 0 }, arrayOfByte72, { 78, 73, 65, 79, 0, 0 }, arrayOfByte73, { 78, 73, 78, 0, 0, 0 }, { 78, 73, 78, 71, 0, 0 }, 
        { 78, 73, 85, 0, 0, 0 }, arrayOfByte74, { 78, 79, 85, 0, 0, 0 }, { 78, 85, 0, 0, 0, 0 }, { 78, 85, 65, 78, 0, 0 }, arrayOfByte75, arrayOfByte76, arrayOfByte77, { 79, 0, 0, 0, 0, 0 }, { 79, 85, 0, 0, 0, 0 }, 
        { 80, 65, 0, 0, 0, 0 }, { 80, 65, 73, 0, 0, 0 }, arrayOfByte78, { 80, 65, 78, 71, 0, 0 }, { 80, 65, 79, 0, 0, 0 }, arrayOfByte79, { 80, 69, 78, 0, 0, 0 }, { 80, 69, 78, 71, 0, 0 }, { 80, 73, 0, 0, 0, 0 }, arrayOfByte80, 
        { 80, 73, 65, 79, 0, 0 }, arrayOfByte81, { 80, 73, 78, 0, 0, 0 }, arrayOfByte82, { 80, 79, 0, 0, 0, 0 }, { 80, 79, 85, 0, 0, 0 }, { 80, 85, 0, 0, 0, 0 }, arrayOfByte83, { 81, 73, 65, 0, 0, 0 }, { 81, 73, 65, 78, 0, 0 }, 
        { 81, 73, 65, 78, 71, 0 }, { 81, 73, 65, 79, 0, 0 }, { 81, 73, 69, 0, 0, 0 }, { 81, 73, 78, 0, 0, 0 }, { 81, 73, 78, 71, 0, 0 }, arrayOfByte84, arrayOfByte85, { 81, 85, 0, 0, 0, 0 }, { 81, 85, 65, 78, 0, 0 }, arrayOfByte86, 
        arrayOfByte87, arrayOfByte88, arrayOfByte89, arrayOfByte90, { 82, 69, 0, 0, 0, 0 }, { 82, 69, 78, 0, 0, 0 }, { 82, 69, 78, 71, 0, 0 }, arrayOfByte91, { 82, 79, 78, 71, 0, 0 }, arrayOfByte92, 
        arrayOfByte93, { 82, 85, 65, 0, 0, 0 }, { 82, 85, 65, 78, 0, 0 }, arrayOfByte94, arrayOfByte95, arrayOfByte96, { 83, 65, 0, 0, 0, 0 }, arrayOfByte97, { 83, 65, 78, 0, 0, 0 }, { 83, 65, 78, 71, 0, 0 }, 
        { 83, 65, 79, 0, 0, 0 }, { 83, 69, 0, 0, 0, 0 }, { 83, 69, 78, 0, 0, 0 }, arrayOfByte98, { 83, 72, 65, 0, 0, 0 }, arrayOfByte99, { 83, 72, 65, 78, 0, 0 }, arrayOfByte100, { 83, 72, 65, 79, 0, 0 }, { 83, 72, 69, 0, 0, 0 }, 
        { 83, 72, 69, 78, 0, 0 }, arrayOfByte101, arrayOfByte102, { 83, 72, 69, 78, 71, 0 }, { 83, 72, 73, 0, 0, 0 }, arrayOfByte103, arrayOfByte104, arrayOfByte105, { 83, 72, 85, 65, 73, 0 }, arrayOfByte106, 
        { 83, 72, 85, 65, 78, 71 }, { 83, 72, 85, 73, 0, 0 }, { 83, 72, 85, 78, 0, 0 }, arrayOfByte107, arrayOfByte108, { 83, 79, 78, 71, 0, 0 }, { 83, 79, 85, 0, 0, 0 }, { 83, 85, 0, 0, 0, 0 }, arrayOfByte109, { 83, 85, 73, 0, 0, 0 }, 
        { 83, 85, 78, 0, 0, 0 }, arrayOfByte110, { 84, 65, 0, 0, 0, 0 }, { 84, 65, 73, 0, 0, 0 }, { 84, 65, 78, 0, 0, 0 }, { 84, 65, 78, 71, 0, 0 }, arrayOfByte111, { 84, 69, 0, 0, 0, 0 }, { 84, 69, 78, 71, 0, 0 }, { 84, 73, 0, 0, 0, 0 }, 
        arrayOfByte112, { 84, 73, 65, 79, 0, 0 }, arrayOfByte113, arrayOfByte114, { 84, 79, 78, 71, 0, 0 }, { 84, 79, 85, 0, 0, 0 }, { 84, 85, 0, 0, 0, 0 }, arrayOfByte115, { 84, 85, 73, 0, 0, 0 }, { 84, 85, 78, 0, 0, 0 }, 
        arrayOfByte116, arrayOfByte117, arrayOfByte118, { 87, 65, 78, 0, 0, 0 }, arrayOfByte119, arrayOfByte120, arrayOfByte121, { 87, 69, 78, 71, 0, 0 }, { 87, 79, 0, 0, 0, 0 }, { 87, 85, 0, 0, 0, 0 }, 
        arrayOfByte122, arrayOfByte123, { 88, 73, 65, 78, 0, 0 }, arrayOfByte124, arrayOfByte125, { 88, 73, 69, 0, 0, 0 }, arrayOfByte126, arrayOfByte127, { 88, 73, 79, 78, 71, 0 }, { 88, 73, 85, 0, 0, 0 }, 
        arrayOfByte128, { 88, 85, 65, 78, 0, 0 }, { 88, 85, 69, 0, 0, 0 }, arrayOfByte129, arrayOfByte130, { 89, 65, 78, 0, 0, 0 }, { 89, 65, 78, 71, 0, 0 }, arrayOfByte131, { 89, 69, 0, 0, 0, 0 }, { 89, 73, 0, 0, 0, 0 }, 
        arrayOfByte132, { 89, 73, 78, 71, 0, 0 }, { 89, 79, 0, 0, 0, 0 }, { 89, 79, 78, 71, 0, 0 }, arrayOfByte133, arrayOfByte134, { 89, 85, 65, 78, 0, 0 }, { 89, 85, 69, 0, 0, 0 }, { 89, 85, 78, 0, 0, 0 }, arrayOfByte135, 
        { 89, 85, 78, 0, 0, 0 }, arrayOfByte136, arrayOfByte137, { 90, 65, 78, 0, 0, 0 }, { 90, 65, 78, 71, 0, 0 }, { 90, 65, 79, 0, 0, 0 }, { 90, 69, 0, 0, 0, 0 }, { 90, 69, 73, 0, 0, 0 }, { 90, 69, 78, 0, 0, 0 }, arrayOfByte138, 
        arrayOfByte139, { 90, 72, 65, 73, 0, 0 }, { 90, 72, 65, 78, 0, 0 }, { 90, 72, 65, 78, 71, 0 }, arrayOfByte140, { 90, 72, 65, 78, 71, 0 }, { 90, 72, 65, 79, 0, 0 }, { 90, 72, 69, 0, 0, 0 }, { 90, 72, 69, 78, 0, 0 }, { 90, 72, 69, 78, 71, 0 }, 
        arrayOfByte141, { 83, 72, 73, 0, 0, 0 }, { 90, 72, 73, 0, 0, 0 }, arrayOfByte142, { 90, 72, 79, 85, 0, 0 }, { 90, 72, 85, 0, 0, 0 }, { 90, 72, 85, 65, 0, 0 }, arrayOfByte143, arrayOfByte144, { 90, 72, 85, 65, 78, 71 }, 
        arrayOfByte145, { 90, 72, 85, 78, 0, 0 }, { 90, 72, 85, 79, 0, 0 }, { 90, 73, 0, 0, 0, 0 }, { 90, 79, 78, 71, 0, 0 }, { 90, 79, 85, 0, 0, 0 }, arrayOfByte146, { 90, 85, 65, 78, 0, 0 }, { 90, 85, 73, 0, 0, 0 }, { 90, 85, 78, 0, 0, 0 }, 
        arrayOfByte147, { 0, 0, 0, 0, 0, 0 }, arrayOfByte148, arrayOfByte149 };
    dFo = Collator.getInstance(Locale.CHINA);
  }
  
  protected ao(boolean paramBoolean) {
    this.dFq = paramBoolean;
    this.dFr = new StringBuilder();
    this.dFs = new StringBuilder();
    this.dFt = new StringBuilder();
  }
  
  private void a(StringBuilder paramStringBuilder, ArrayList<b> paramArrayList, int paramInt) {
    String str = paramStringBuilder.toString();
    paramArrayList.add(new b(paramInt, str, str));
    paramStringBuilder.setLength(0);
  }
  
  public static ao asV() { // Byte code:
    //   0: ldc com/laiqian/util/ao
    //   2: monitorenter
    //   3: getstatic com/laiqian/util/ao.dFp : Lcom/laiqian/util/ao;
    //   6: ifnull -> 18
    //   9: getstatic com/laiqian/util/ao.dFp : Lcom/laiqian/util/ao;
    //   12: astore_1
    //   13: ldc com/laiqian/util/ao
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: invokestatic getAvailableLocales : ()[Ljava/util/Locale;
    //   21: astore_1
    //   22: iconst_0
    //   23: istore_0
    //   24: iload_0
    //   25: aload_1
    //   26: arraylength
    //   27: if_icmpge -> 62
    //   30: aload_1
    //   31: iload_0
    //   32: aaload
    //   33: getstatic java/util/Locale.CHINESE : Ljava/util/Locale;
    //   36: invokevirtual equals : (Ljava/lang/Object;)Z
    //   39: ifeq -> 98
    //   42: new com/laiqian/util/ao
    //   45: dup
    //   46: iconst_1
    //   47: invokespecial <init> : (Z)V
    //   50: putstatic com/laiqian/util/ao.dFp : Lcom/laiqian/util/ao;
    //   53: getstatic com/laiqian/util/ao.dFp : Lcom/laiqian/util/ao;
    //   56: astore_1
    //   57: ldc com/laiqian/util/ao
    //   59: monitorexit
    //   60: aload_1
    //   61: areturn
    //   62: ldc_w 'HanziToPinyin'
    //   65: ldc_w 'There is no Chinese collator, HanziToPinyin is disabled'
    //   68: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   71: pop
    //   72: new com/laiqian/util/ao
    //   75: dup
    //   76: iconst_0
    //   77: invokespecial <init> : (Z)V
    //   80: putstatic com/laiqian/util/ao.dFp : Lcom/laiqian/util/ao;
    //   83: getstatic com/laiqian/util/ao.dFp : Lcom/laiqian/util/ao;
    //   86: astore_1
    //   87: ldc com/laiqian/util/ao
    //   89: monitorexit
    //   90: aload_1
    //   91: areturn
    //   92: astore_1
    //   93: ldc com/laiqian/util/ao
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    //   98: iload_0
    //   99: iconst_1
    //   100: iadd
    //   101: istore_0
    //   102: goto -> 24
    // Exception table:
    //   from	to	target	type
    //   3	16	92	finally
    //   18	22	92	finally
    //   24	60	92	finally
    //   62	90	92	finally
    //   93	96	92	finally }
  
  private b m(char paramChar) {
    b b = new b();
    null = Character.toString(paramChar);
    b.dFx = null;
    if (paramChar < 'Ā') {
      b.type = 1;
      b.dFy = null;
      return b;
    } 
    int j = dFo.compare(null, "阿");
    if (j < 0) {
      b.type = 3;
      b.dFy = null;
      return b;
    } 
    int m = 0;
    if (j == 0) {
      b.type = 2;
      i = 0;
    } else {
      j = dFo.compare(null, "鿿");
      if (j > 0) {
        b.type = 3;
        b.dFy = null;
        return b;
      } 
      if (j == 0) {
        b.type = 2;
        i = dFm.length - 1;
      } else {
        i = -1;
      } 
    } 
    b.type = 2;
    if (i < 0) {
      int i1 = dFm.length - 1;
      int n = 0;
      while (n <= i1) {
        i = (n + i1) / 2;
        String str = Character.toString(dFm[i]);
        j = dFo.compare(null, str);
        if (j == 0)
          break; 
        if (j > 0) {
          n = i + 1;
          continue;
        } 
        i1 = i - 1;
      } 
    } 
    int k = i;
    if (j < 0)
      k = i - 1; 
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = m; i < dFn[k].length && dFn[k][i] != 0; i++)
      stringBuilder.append((char)dFn[k][i]); 
    b.dFy = stringBuilder.toString();
    if (TextUtils.isEmpty(b.dFy)) {
      b.type = 3;
      b.dFy = b.dFx;
    } 
    return b;
  }
  
  private char n(char paramChar) {
    char c = paramChar;
    if (paramChar >= 'a') {
      c = paramChar;
      if (paramChar <= 'z')
        c = (char)(paramChar - ' '); 
    } 
    if (c >= 'A' && c <= 'Z') {
      char c1;
      if (c > 'Y') {
        c1 = c - 'A' - '\002';
      } else if (c > 'R') {
        c1 = c - 'A' - '\001';
      } else {
        c1 = c - 'A';
      } 
      return (char)(c1 / '\003' + '2');
    } 
    return c;
  }
  
  public ArrayList<b> qx(String paramString) {
    ArrayList arrayList = new ArrayList();
    if (this.dFq) {
      if (TextUtils.isEmpty(paramString))
        return arrayList; 
      int j = paramString.length();
      StringBuilder stringBuilder = new StringBuilder();
      byte b = 0;
      int i;
      for (i = 1; b < j; i = k) {
        int k;
        char c = paramString.charAt(b);
        if (c == ' ') {
          k = i;
          if (stringBuilder.length() > 0) {
            a(stringBuilder, arrayList, i);
            k = i;
          } 
        } else if (c < 'Ā') {
          if (i != 1 && stringBuilder.length() > 0)
            a(stringBuilder, arrayList, i); 
          stringBuilder.append(c);
          k = 1;
        } else {
          b b1 = m(c);
          if (b1.type == 2) {
            if (stringBuilder.length() > 0)
              a(stringBuilder, arrayList, i); 
            arrayList.add(b1);
            k = 2;
          } else {
            if (i != b1.type && stringBuilder.length() > 0)
              a(stringBuilder, arrayList, i); 
            k = b1.type;
            stringBuilder.append(c);
          } 
        } 
        b++;
      } 
      if (stringBuilder.length() > 0)
        a(stringBuilder, arrayList, i); 
      return arrayList;
    } 
    return arrayList;
  }
  
  @NonNull
  public a qy(String paramString) {
    this.dFr.setLength(0);
    this.dFs.setLength(0);
    this.dFt.setLength(0);
    for (b b1 : qx(paramString)) {
      byte b;
      for (b = 0; b < b1.dFy.length(); b++) {
        char c1 = b1.dFy.charAt(b);
        char c2 = n(c1);
        if (c2 >= '0' && c2 <= '9') {
          if (b == 0 || b1.type == 1) {
            this.dFs.append(c2);
            if (c1 >= 'A' && c1 <= 'Z') {
              this.dFr.append((char)(c1 - 'A' + 'a'));
            } else {
              this.dFr.append(c1);
            } 
          } 
          this.dFt.append(c2);
        } 
      } 
    } 
    return new a(this.dFr.toString(), this.dFs.toString(), this.dFt.toString(), null);
  }
  
  public static class a {
    public final String dFu;
    
    public final String dFv;
    
    public final String dFw;
    
    private a(String param1String1, String param1String2, String param1String3) {
      this.dFu = param1String1;
      this.dFv = param1String2;
      this.dFw = param1String3;
    }
  }
  
  public static class b {
    public String dFx;
    
    public String dFy;
    
    public int type;
    
    public b() {}
    
    public b(int param1Int, String param1String1, String param1String2) {
      this.type = param1Int;
      this.dFx = param1String1;
      this.dFy = param1String2;
    }
  }
}


/* Location:              F:\chrome_download\android-Decompile\dex2jar-2.0\classes2-dex2jar.jar!\com\laiqia\\util\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.4
 */