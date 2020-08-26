package lab;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HtmlUnitDemo {
    public static void main(String[] args) throws IOException {
        //无界面的浏览器（HTTP客户端）
        //WebClient是一个浏览器类，浏览器版本是CHROME。即模拟是CHROME浏览器
        WebClient webClient=new WebClient(BrowserVersion.CHROME);
        //关闭浏览器的js执行引擎，不再执行网页中的js脚本
        webClient.getOptions().setJavaScriptEnabled(false);
        //关闭浏览器的css执行引擎，不再执行网页中的css布局
        webClient.getOptions().setCssEnabled(false);
        //列表页信息。最后得出HtmlPage的对象
        HtmlPage page=webClient.getPage("https://so.gushiwen.org/gushi/tangshi.aspx");
        System.out.println(page);
        //page.save(new File("唐诗三百首\\列表页.html"));
        File file=new File("唐诗三百首\\列表页.html");
        page.save(file);

        //从html中提取我们需要的信息
        HtmlElement body=page.getBody();
        List<HtmlElement> elements=body.getElementsByAttribute(
                "div","class","typecont");
        int count=0;
        for(HtmlElement element:elements){
            List<HtmlElement> aElements= element.getElementsByTagName("a");
            for (HtmlElement a:aElements){
                System.out.println(a.getAttribute("href"));
                count++;
            }
        }
        System.out.println(count);
        /*
        HtmlElement divElement=elements.get(0);
        List<HtmlElement> aElements=divElement.getElementsByAttribute("a","target","_blank");
        for(HtmlElement e:aElements){
            System.out.println(e);
        }
        //System.out.println(aElements.size());
        //System.out.println(aElements.get(0).getAttribute("href"));
        Element element= (Element) page.getElementById("contson45c396367f59").getTextContent();
        System.out.println(element);
        */
        {
            String xpath="";
        }
    }

}
