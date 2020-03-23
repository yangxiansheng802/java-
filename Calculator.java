package Person;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class Calculator extends Frame implements ActionListener, TextListener {
    private TextArea xf;
            Button x1;
            Button x2;
            Button x3;
            Button x4;
            Button x5;
            Button x6;
            Button x7;
            Button x8;
            Button x9;
            Button x0;
            Button xa;
            Button xb;
            Button xc;
            Button xd;
            Button xe;
            Button xg;
            Panel c=new Panel();
    public Calculator(){
        super("Calculator");
         x1=new Button("1");
         x2=new Button("2");
         x3=new Button("3");
         x4=new Button("4");
         x5=new Button("5");
         x6=new Button("6");
         x7=new Button("7");
         x8=new Button("8");
         x9=new Button("9");
         x0=new Button("0");
         xa=new Button("+");
         xb=new Button("-");
         xc=new Button("*");
         xd=new Button("/");
         xe=new Button("=");
         xg=new Button("clear");
        xf=new TextArea(1,600);
        setLayout(new BorderLayout());
        add("North",xf);
        c.setLayout(new GridLayout(4,4,10,10));
        c.add(x1);
        c.add(x2);
        c.add(x3);
        c.add(xa);
        c.add(x4);
        c.add(x5);
        c.add(x6);
        c.add(xb);
        c.add(x7);
        c.add(x8);
        c.add(x9);
        c.add(xc);
        c.add(x0);
        c.add(xd);
        c.add(xe);
        c.add(xg);
        add(c);
        xf.addTextListener(this);
        x1.addActionListener(this);
        x2.addActionListener(this);
        x3.addActionListener(this);
        x4.addActionListener(this);
        x5.addActionListener(this);
        x6.addActionListener(this);
        x7.addActionListener(this);
        x8.addActionListener(this);
        x9.addActionListener(this);
        x0.addActionListener(this);
        xa.addActionListener(this);
        xb.addActionListener(this);
        xc.addActionListener(this);
        xd.addActionListener(this);
        xe.addActionListener(this);
        xg.addActionListener(this);
        addWindowListener(new closeW());
    }
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand()=="clear")
        { xf.setText("");
         return;}
        if(e.getActionCommand()!="=")
        xf.append(e.getActionCommand());
        else
        {
            String s = xf.getText();
            String y="";
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
            ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("javascript");
            try {
                y = String.valueOf(scriptEngine.eval(s));
            }catch (ScriptException e1){
                e1.printStackTrace();
            }finally {
            xf.setText("");
            xf.setText(y);}
        }
    }
    public void textValueChanged(TextEvent e){
    }

    public static void main(String[] args) {
        Frame m=new Calculator();
        m.setBackground(Color.white);
        m.setSize(400,400);
        m.setVisible(true);
    }
}
