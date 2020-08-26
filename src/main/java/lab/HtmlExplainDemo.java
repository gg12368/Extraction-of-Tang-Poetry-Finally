package lab;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class HtmlExplainDemo {
    public static void main(String[] args) throws IOException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //关闭了浏览器的js执行引擎和css执行引擎
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);

        //请求页面
        HtmlPage page = webClient.getPage("https://so.gushiwen.org/shiwenv_45c396367f59.aspx");

        //获取html的body标签的内容
        HtmlElement body = page.getBody();
        /*
        List<HtmlElement> elements=body.getElementsByAttribute(
                "div","class","contson");
        for(HtmlElement element:elements){
            System.out.println(element);
        }
        System.out.println(elements.get(0).getTextContent().trim());
        */
        //爬取标签路径
        String xPath;
        {
            //获得标题、朝代作者等信息，根据xPath
            xPath = "//div[@class='cont']/h1/text()";
            Object o = body.getByXPath(xPath).get(0);
            DomText domText = (DomText)o;
            //标题
            String title = domText.asText();
            System.out.println("标题："+title);
        }

        //接下来获取朝代和作者
        {
            //朝代
            xPath = "//div[@class='cont']/p[@class='source']/a[1]/text()";
            Object o = body.getByXPath(xPath).get(0);
            DomText domText = (DomText)o;
            //朝代
            String dynasty = domText.asText();
            System.out.println("朝代:"+dynasty);

        }

        {
            //作者
            xPath = "//div[@class='cont']/p[@class='source']/a[2]/text()";
            Object o = body.getByXPath(xPath).get(0);
            DomText domText = (DomText)o;
            //作者
            String user = domText.asText();
            System.out.println("作者："+user);

        }

        {
            //古诗词内容
            xPath = "//div[@class='cont']/div[@class='contson']";
            Object o = body.getByXPath(xPath).get(0);
            HtmlElement htmlElement = (HtmlElement)o;
            //正文
            String content = htmlElement.getTextContent();
            System.out.println("正文："+content.trim());

        }
    }
}
