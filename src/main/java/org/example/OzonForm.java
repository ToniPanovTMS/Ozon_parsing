package org.example;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author t.panov
 */

public class OzonForm extends JPanel {
    static ArrayList<String[]> Tabel_List;
    static String URL_Bodi;
    static String category="",request;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ozon");
        frame.setContentPane(new OzonForm());
        frame.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - 1200 / 2, dim.height / 2 - 800 / 2, 1215, 840);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public OzonForm() {
        initComponents();
    }
    private void textField1(ActionEvent e) {
        request=textField1.getText();
    }
    private void textField1CaretUpdate(CaretEvent e) {
        request=textField1.getText();
    }
    private void comboBox1(ActionEvent e) {
        switch ((String)comboBox1.getSelectedItem()){
            case "Электроника":
                category="category/elektronika-15500/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case "Одежда":
                category="category/muzhskaya-obuv-7658/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Обувь"):
                category="category/obuv-17777/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Дом и сад"):
                category="category/dom-i-sad-14500/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Детские товары"):
                category="category/detskie-tovary-7000/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Красота и здоровье"):
                category="category/krasota-i-zdorove-6500/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Бытовая техника"):
                category="category/bytovaya-tehnika-10500/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Спорт и отдых"):
                category="category/sport-i-otdyh-11000/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Строительство и ремонт"):
                category="category/stroitelstvo-i-remont-9700/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Продукты питания"):
                category="category/produkty-pitaniya-9200/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Аптека"):
                category="category/apteka-6000/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Товары для животных"):
                category="category/etovary-dlya-zhivotnyh-12300/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Книги"):
                category="category/knigi-16500/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Туризм, рыбалка, охота"):
                category="category/ohota-rybalka-turizm-33332/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Автотовары"):
                category="category/avtotovary-8500/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Мебель"):
                category="category/mebel-15000/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Хобби и творчество"):
                category="category/hobbi-i-tvorchestvo-13500/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Ювелирные украшения"):
                category="category/yuvelirnye-ukrasheniya-50001/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Аксессуары"):
                category="category/aksessuary-7697/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Игры и консоли"):
                category="category/igry-i-soft-13300/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Канцелярские товары"):
                category="category/kantselyarskie-tovary-18000/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Товары для взрослых"):
                category="category/tovary-dlya-vzroslyh-9000/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Антиквариат и коллекционирование"):
                category="category/antikvariat-vintazh-iskusstvo-8000/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Цифровые товары"):
                category="category/tsifrovye-tovary-32056/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Бытовая химия и гигиена"):
                category="category/bytovaya-himiya-14572/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Ozon fresh"):
                category="category/supermarket-25000/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Музыка и видео"):
                category="category/muzyka-i-video-13100/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Автомобили"):
                category="category/avtomobili-39803/?category_was_predicted=true&deny_category_prediction=true&from_global=true";
                break;
            case("Всё остальное"):
                category="search/";
                break;
            case(""):
                category="search/";
                break;
        }
    }
    private void textField1AncestorAdded(AncestorEvent e) {
        // TODO add your code here
    }
    private void button1(ActionEvent e) throws IOException, InterruptedException {
        url_generation_info(request,category);
        info_on_ozon();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - toni panov
        label1 = new JLabel();
        textField1 = new JTextField();
        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        button1 = new JButton();
        vSpacer1 = new JPanel(null);

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
        ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
        .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
        ;} } );
        setLayout(null);

        //---- label1 ----
        label1.setText("\u0427\u0442\u043e \u0438\u0449\u0438\u043c?");
        add(label1);
        label1.setBounds(30, 15, 90, 30);

        //---- textField1 ----
        textField1.addActionListener(e -> {
			textField1(e);
			textField1(e);
			textField1(e);
		});
        textField1.addCaretListener(e -> {
			textField1CaretUpdate(e);
			textField1CaretUpdate(e);
		});
        textField1.addAncestorListener(new AncestorListener() {
            @Override
            public void ancestorAdded(AncestorEvent e) {
                textField1AncestorAdded(e);
            }
            @Override
            public void ancestorMoved(AncestorEvent e) {}
            @Override
            public void ancestorRemoved(AncestorEvent e) {}
        });
        add(textField1);
        textField1.setBounds(100, 15, 505, 30);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                "Всё остальное","Электроника","Одежда","Обувь","Дом и сад","Детские товары","Красота и здоровье","Бытовая техника","Спорт и отдых","Строительство и ремонт","Продукты питания", "Аптека","Товары для животных","Книги","Туризм, рыбалка, охота","Автотовары","Мебель","Хобби и творчество","Ювелирные украшения","Аксессуары","Игры и консоли","Канцелярские товары","Товары для взрослых","Антиквариат и коллекционирование","Цифровые товары","Бытовая химия и гигиена","Ozon fresh","Музыка и видео","Автомобили"
        }));
        comboBox1.addActionListener(e -> comboBox1(e));
        add(comboBox1);
        comboBox1.setBounds(620, 15, 245, comboBox1.getPreferredSize().height);

        //---- comboBox2 ----
        //---- button1 ----
        button1.setText("\u0418\u0441\u043a\u0430\u0442\u044c");
        button1.addActionListener(e -> {
			try {
button1(e);} catch (IOException ex) {
    throw new RuntimeException(ex);
} catch (InterruptedException ex) {
    throw new RuntimeException(ex);
}
		});
        add(button1);
        button1.setBounds(1045, 15, 98, button1.getPreferredSize().height);
        add(vSpacer1);
        vSpacer1.setBounds(1120, 50, 30, 730);

        //---- table1 ----
        table1.setIntercellSpacing(new Dimension(0, 0));
        table1.setMaximumSize(null);
        add(table1);
        table1.setBounds(15, 50, 1138, 730);

        setPreferredSize(new Dimension(1190, 800));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }
    static void url_generation_info(String request,String category){
        request=request.replace(' ','+');
        if(category.equals("search/")||category.equals("")){URL_Bodi="https://ozon.by/search/?category_was_predicted=true&deny_category_prediction=true&from_global=true&text="+request;
        }else{URL_Bodi="https://ozon.by/"+category+"&text="+request;}
    }
    static void info_on_ozon() throws IOException {
        for (int i=0;i<5;i++){//ищим только первые 10 страниц, ибо поиск займёт пол года...........
            Document page = null;
            page = Jsoup.parse(new URL(URL_Bodi), 10000);
            Element div = page.select("div[class=er4]").first();

            for (int j = 0; j < 8; j++) {
                Element a_class = div.select("a[class=v5i tile-hover-target]").get(j);
                info_on_ozon("https://ozon.by" + a_class.attr("href"), (i*8)+j);
            }
            Element div_next = page.select("div[class=eq7 a2429-a]").first();
            Element a_class = div_next.select("a").first();
            URL_Bodi="https://ozon.by"+a_class.attr("href");
        }

    }
    static void info_on_ozon(String URL,int id) throws IOException{
        Document page= Jsoup.parse(new URL(URL),10000);
        Element prise_elem= page.select("span[class=p3l lp4 p7l]").first();;
        Element Name_elem = page.select("h1[class=lp9]").first();
        String name,prise;
        try {
            name=Name_elem.text();
        } catch (Exception e){
            name="";
        }
        try{
            prise=prise_elem.text();
        }catch (Exception e){
            prise="";
        }
        String text =prise;
        String[] prises = text.split(" ");
        System.out.println(id+1+" "+name+" "+prises[0]+" "+URL);

    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - toni panov
    private JLabel label1;
    private JTextField textField1;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JButton button1;
    private JPanel vSpacer1;
    static private JTable table1=new JTable();
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
