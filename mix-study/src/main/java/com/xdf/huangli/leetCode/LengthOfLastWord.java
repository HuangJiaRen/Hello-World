package com.xdf.huangli.leetCode;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>
 *
 * </P>
 *
 * @author huangli
 * @since 4/13/23 10:42 AM
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s){
        String[] split = s.split(StringUtils.SPACE);
        return split[split.length -  1].length();
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon ";
        String[] split = s.split(StringUtils.SPACE);
        System.out.println(JSON.toJSONString(split));
        System.out.println(split[split.length -  1].length());
    }
}
