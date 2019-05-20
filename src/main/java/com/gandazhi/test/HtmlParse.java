package com.gandazhi.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @Auther: gandazhi
 * @Date: 2019-05-20 10:27
 */
public class HtmlParse {

  public static void main(String[] args) {
    String html = "<select name=\"seller_certificateType\" class=\"seller_certificateType\"\n" +
      "                                                        v-model=\"sellerInfo.seller_certificateType\">\n" +
      "                                                    <option value=\"111\">居民身份证</option>\n" +
      "                                                    <option value=\"112\">临时居民身份证</option>\n" +
      "                                                    <option value=\"113\">户口簿</option>\n" +
      "                                                    <option value=\"114\">中国人民解放军军官证</option>\n" +
      "                                                    <option value=\"115\">中国人民武装警察部队警官证</option>\n" +
      "                                                    <option value=\"117\">出生医学证明</option>\n" +
      "                                                    <option value=\"118\">中国人民解放军士兵证</option>\n" +
      "                                                    <option value=\"119\">中国人民武装警察部队士兵证</option>\n" +
      "                                                    <option value=\"120\">中国人民解放军文职人员证</option>\n" +
      "                                                    <option value=\"122\">中国人民武装警察部队文职人员证</option>\n" +
      "                                                    <option value=\"154\">居住证</option>\n" +
      "                                                    <option value=\"411\">外交护照</option>\n" +
      "                                                    <option value=\"412\">公务护照</option>\n" +
      "                                                    <option value=\"413\">公务普通护照</option>\n" +
      "                                                    <option value=\"414\">普通护照</option>\n" +
      "                                                    <option value=\"415\">旅行证</option>\n" +
      "                                                    <option value=\"418\">外国人旅行证</option>\n" +
      "                                                    <option value=\"511\">台湾居民来往大陆通行证</option>\n" +
      "                                                    <option value=\"516\">港澳居民来往内地通行证</option>\n" +
      "                                                    <option value=\"553\">外国人永久居留身份证</option>\n" +
      "                                                    <option value=\"554\">外国人居留证或居留许可</option>\n" +
      "                                                    <option value=\"555\">外国人临时居留证</option>\n" +
      "                                                    <option value=\"791\">外交人员身份证明</option>\n" +
      "                                                    <option value=\"792\">境外人员身份证明</option>\n" +
      "                                                </select>";

    Document doc = Jsoup.parseBodyFragment(html);
    Element body = doc.body();
    for (Element allElement : body.getAllElements()) {
      System.out.print(allElement.attr("value") + "|");
      System.out.println(allElement.text());
    }
  }
}
