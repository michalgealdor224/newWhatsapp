import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class OpenWindow extends JPanel {
    JButton button = new JButton("whatsapp web");
    private ImageIcon background;
    private JLabel succeedToEnter;
    private TextField phoneNumber;
    private JLabel enterNumber;
    private TextField textToSend;
    private JLabel enterText;
    private ChromeDriver driver;
    private JLabel vi;
    private JLabel error;
    private boolean trySend = true;
    public static final int X_OF_WINDOW = 0,Y_OF_WINDOW = 0,WIDTH_OF_WINDOW = 700,HEIGHT_OF_WINDOW = 600,X_OF_BUTTON = 250,Y_OF_BUTTON = 100,
            WIDTH_OF_BUTTON = 200,HEIGHT_OF_BUTTON = 70,Y_OF_SUCCEED = 150,WIDTH_OF_SUCCEED = 300,SIZE_OF_TEXT = 20,
    X_OF_PHONE_NUMBER =300, Y_OF_PHONE_NUMBER= 250,WIDTH_OF_PHONE_NUMBER= 250,HEIGHT_OF_PHONE_NUMBER= 250,
            X_OF_ENTER_NUMBER =300, Y_OF_ENTER_NUMBER= 220,WIDTH_OF_ENTER_NUMBER= 200,HEIGHT_OF_ENTER_NUMBER= 20,
            X_OF_ENTER_TEXT =300, Y_OF_ENTER_TEXT= 280,WIDTH_OF_ENTER_TEXT= 200,HEIGHT_OF_ENTER_TEXT= 20,
            X_OF_TEXT_TO_SEND =300, Y_OF_TEXT_TO_SEND= 320,WIDTH_OF_TEXT_TO_SEND= 100,HEIGHT_OF_TEXT_TO_SEND= 50,
            X_OF_VI =300, Y_OF_VI= 380,WIDTH_OF_VI= 70,HEIGHT_OF_VI= 40,
            X_OF_ERROR =350, Y_OF_ERROR= 380,WIDTH_OF_ERROR= 70,HEIGHT_OF_ERROR= 40,SIZE_OF_LABEL = 15;
    public static final int LAST_MESSAGE =1,START_LOCATION =0, LOCATION_ONE =1,
    X_MESSAGE_COMMENT = 400, Y_MESSAGE_COMMENT = 400, WIDTH_MESSAGE_COMMENT = 200, HEIGHT_MESSAGE_COMMENT = 50,
    LOCATION_TWO =2, TEN_SECOND =10000,LENGTH_NUMBER_VALID =12, LENGTH_VALID =10;














    public static void main(String[] args) {


    }
    public OpenWindow () {
        this.setBounds(X_OF_WINDOW, Y_OF_WINDOW, WIDTH_OF_WINDOW, HEIGHT_OF_WINDOW);
        this.setFocusable(true);
        this.requestFocus();
        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.setVisible(true);
        new Thread( () -> {
            button.setBounds(X_OF_BUTTON, Y_OF_BUTTON, WIDTH_OF_BUTTON, HEIGHT_OF_BUTTON);
            add(button);
            this.background = new ImageIcon("whatsapp.jpeg");
            succeedToEnter = new JLabel("ההתחברות בוצעה בהצלחה!");
            succeedToEnter.setBounds(X_OF_BUTTON,Y_OF_SUCCEED,WIDTH_OF_SUCCEED,HEIGHT_OF_BUTTON);
            this.succeedToEnter.setFont(new Font("TimesRoman", Font.BOLD, SIZE_OF_TEXT));
            this.phoneNumber = new TextField();
            this.phoneNumber.setBounds(X_OF_PHONE_NUMBER,Y_OF_PHONE_NUMBER,WIDTH_OF_PHONE_NUMBER,HEIGHT_OF_PHONE_NUMBER);
            enterNumber = new JLabel( "הכנס מספר נמען:");
            enterNumber.setBounds(X_OF_ENTER_NUMBER,Y_OF_ENTER_NUMBER,WIDTH_OF_ENTER_NUMBER,HEIGHT_OF_ENTER_NUMBER);
            this.enterNumber.setFont(new Font("TimesRoman", Font.BOLD, SIZE_OF_LABEL));
            enterText = new JLabel("הכנס טקסט לשליחה:");
            enterText.setBounds(X_OF_ENTER_TEXT,Y_OF_ENTER_TEXT,WIDTH_OF_ENTER_TEXT,HEIGHT_OF_ENTER_TEXT);
            this.enterText.setFont(new Font("TimesRoman", Font.BOLD, SIZE_OF_LABEL));
            this.textToSend = new TextField();
            this.textToSend.setBounds(X_OF_TEXT_TO_SEND,Y_OF_TEXT_TO_SEND,WIDTH_OF_TEXT_TO_SEND,HEIGHT_OF_TEXT_TO_SEND);
            this.vi = new JLabel("סטטוס");
            this.vi.setBounds(X_OF_VI,Y_OF_VI,WIDTH_OF_VI,HEIGHT_OF_VI);
            this.vi.setFont(new Font("TimesRoman", Font.BOLD, SIZE_OF_LABEL));
            this.error = new JLabel("מספר הטלפון אינו תקין");
            this.error.setBounds(X_OF_ERROR,Y_OF_ERROR,WIDTH_OF_ERROR,HEIGHT_OF_ERROR);
            this.error.setFont(new Font("TimesRoman", Font.BOLD, SIZE_OF_LABEL));
            add(phoneNumber);
            add(enterNumber);
            add(enterText);
            add(textToSend);
            add(vi);
            repaint();

        }).start();


        Thread thread = new Thread( () -> {

            //JOptionPane.showMessageDialog(null,"ההתחברות בוצעה בהצלחה (:","title",JOptionPane.INFORMATION_MESSAGE);

            AtomicBoolean valid = new AtomicBoolean(false);
            button.addActionListener((event1) -> {

                String number = phoneNumber.getText();
                String text = textToSend.getText();
                if (Objects.equals(number, "")) {
                    JOptionPane.showMessageDialog(null, "not have number", "title", JOptionPane.ERROR_MESSAGE);
                    valid.set(false);

                }
                if (!ifValid(number)) {
                    JOptionPane.showMessageDialog(null, "Invalid number", "title", JOptionPane.ERROR_MESSAGE);
                    valid.set(false);

                }
                if (Objects.equals(text, "")) {
                    JOptionPane.showMessageDialog(null, "No text entered", "title", JOptionPane.ERROR_MESSAGE);
                    valid.set(false);

                }
                if (number.charAt(START_LOCATION) == '0') {
                    number = "972" + number.substring(LOCATION_ONE);
                    valid.set(true);
                }
                if (ifValid(number)) {
                    valid.set(true);
                }


                if (valid.get()) {
                    String finalNumber = number;
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver_win32\\chromedriver.exe");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().window().maximize();
                    driver.get("https://web.whatsapp.com/send?phone=" + finalNumber);
                    driver.manage().window().maximize();
                    var ref = new Object() {
                        boolean ifHave = false;
                    };
                    //  Thread errorT = new Thread(() ->{
                    //    while (!ref.ifHave)
                    //  try {
                    //    WebElement error = driver.findElement(By.className("_2Nr6U"));
                    //  if (error.isDisplayed()){
                    //    System.out.println("error");
                    //  ref.ifHave =true;
                    //             WebElement clickError = driver.findElement(By.cssSelector("div[role='button'][tabindex='0']"));
                    //           clickError.click();
                    //add(this.error);
                    //         repaint();

                    //   }

                    //   } catch (Exception e){

//                            }

                    //                      });errorT.start();


                    while (trySend) {
                        try {
                            WebElement userName = driver.findElement(By.cssSelector("div[title=\"הקלדת ההודעה\"]"));
                            userName.sendKeys(text);
                            trySend = false;
                        } catch (Exception ignored) {
                        }
                    }
                    while (!trySend) {
                        try {
                            WebElement send = driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[2]/button"));
                            send.click();
                            //  JOptionPane.showMessageDialog(null,"ההודעה נשלחה בהצלחה (:","title",JOptionPane.INFORMATION_MESSAGE);
                            trySend = true;
                        } catch (Exception ignored) {

                        }
                    }
                    WebElement chat = this.driver.findElement(By.className("_33LGR"));
                    WebElement chatBody = chat.findElement(By.cssSelector("div[tabindex='-1'][class='_3K4-L']"));
                    List<WebElement> allMessage = chatBody.findElements(By.cssSelector("div[tabindex='-1']"));
                    WebElement lastMessage = allMessage.get(allMessage.size() - LAST_MESSAGE);
                    AtomicBoolean flag = new AtomicBoolean(true);

                    new Thread(() -> {
                        WebElement status;
                        String statusMessage= " ";
                        boolean ifSend = false;
                        while (flag.get()) {
                            try {
                                if (!ifSend){
                                    status = lastMessage.findElement(By.cssSelector("span[data-testid='msg-check']"));
                                    statusMessage = status.getAttribute("aria-label");
                                    if (statusMessage.equals(" נשלחה ")) {
                                        System.out.println("נשלחה");
                                        vi.setText("V");
                                        repaint();
                                        ifSend = true;
                                    }
                                }
                                status = lastMessage.findElement(By.cssSelector("span[data-testid='msg-dblcheck']"));
                                statusMessage = status.getAttribute("aria-label");


                                if (statusMessage.equals(" נמסרה ")) {
                                    System.out.println("נמסרה");
                                    add(vi);
                                    vi.setText("VV");
                                    repaint();
                                }
                                if (statusMessage.equals(" נקראה ")) {
                                    System.out.println("נקראה");
                                    vi.setText("VV");
                                    vi.setForeground(Color.blue);
                                    repaint();
                                    flag.set(false);
                                }

                            } catch (Exception e) {
                                System.out.println(".");

                            }
                        }
                        try {
                            while (true){
                                List <WebElement> comment = driver.findElements(By.cssSelector("div[tabindex = '-1'][role = 'region']"));
                             String messageLas = comment.get(START_LOCATION).getText();
                                 String[] messageLass = messageLas.split(" ");
                                for (int i = 0; i < messageLass.length; i++) {
                                    //System.out.println(messageLass[i] + i +"  this");

                                }
                                String messageClass = lastMessage.getAttribute("class");
                                if (messageClass.contains("message-in")) {
                                    WebElement comment2 = lastMessage.findElement(By.cssSelector("span[dir='rtl']"));
                                    //System.out.println(comment2.getText());
                                }
                                JLabel messageComment=new JLabel("");
                                messageComment.setBounds(X_MESSAGE_COMMENT,Y_MESSAGE_COMMENT,WIDTH_MESSAGE_COMMENT,HEIGHT_MESSAGE_COMMENT);

                                for (int i=0; i< comment.size(); i++){
                                   List<String > mes = Collections.singletonList(comment.get(i).getText());
                                   List<String> m = List.of(mes.get(START_LOCATION).split(" שלא "));
                                   //System.out.println(m.get(i) + "ההודעה האחרונה");
                                   System.out.println(mes.get(i));
                                   //System.out.println(comment.get(i).getText());
                                   String[] last = mes.get(i).split("\n");
                                   System.out.println(last[last.length-LOCATION_TWO] + "**********");
                                    messageComment = new JLabel(last[last.length-LOCATION_TWO]);
                                   add(messageComment);
                                   repaint();
                                    Thread.sleep(TEN_SECOND);
                               }
                            }

                        }catch (Exception e){

                        }
                    }).start();
                }
            });
        });thread.start();
    }


    public void sendMessage(ChromeDriver driver, String message){
        while (trySend){
            try{
                WebElement userName =driver.findElement(By.cssSelector("div[title=\"הקלדת ההודעה\"]"));
                userName.sendKeys(message);
                trySend = false;
            }catch (Exception e){
                sendMessage(driver, message);
            }
        }
    }



    public static boolean ifValid (String phoneNumber) {
        boolean isValid =false;
        if (phoneNumber.charAt(START_LOCATION)=='9' && phoneNumber.charAt(LOCATION_ONE)=='7' && phoneNumber.charAt(LOCATION_TWO)=='2' && phoneNumber.length()==LENGTH_NUMBER_VALID) {
            isValid=true;
        }
        if (phoneNumber.length()==LENGTH_VALID && phoneNumber.charAt(START_LOCATION) =='0' && phoneNumber.charAt(LOCATION_ONE)=='5'){
            isValid= true;
        }
        return isValid;
    }

    protected void paintComponent (Graphics g){
        super.paintComponent(g);
        if (this.background != null) {
            g.drawImage(this.background.getImage(), X_OF_WINDOW, Y_OF_WINDOW, WIDTH_OF_WINDOW, HEIGHT_OF_WINDOW, null);
        }
    }
}


