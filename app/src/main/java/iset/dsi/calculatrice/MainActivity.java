package iset.dsi.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
double firstnum;
double secondnum;
String operation;
double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button num0 = findViewById(R.id.n0);
        Button num1 = findViewById(R.id.n1);
        Button num2 = findViewById(R.id.n2);
        Button num3 = findViewById(R.id.n3);
        Button num4 = findViewById(R.id.n4);
        Button num5 = findViewById(R.id.n5);
        Button num6 = findViewById(R.id.n6);
        Button num7 = findViewById(R.id.n7);
        Button num8 = findViewById(R.id.n8);
        Button num9 = findViewById(R.id.n9);

        Button on = findViewById(R.id.on);
        Button off = findViewById(R.id.off);
        Button del = findViewById(R.id.del);
        Button ac = findViewById(R.id.ac);
        Button point = findViewById(R.id.point);
        Button div = findViewById(R.id.div);
        Button mul = findViewById(R.id.mul);
        Button soutra = findViewById(R.id.soutr);
        Button add = findViewById(R.id.add);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button eg = findViewById(R.id.egal);


        TextView t =findViewById(R.id.res);
        ac.setOnClickListener(view -> {
            firstnum = 0;
            t.setText("0");
        });
        off.setOnClickListener(view -> t.setVisibility(view.GONE));
        on.setOnClickListener(view ->
        {
            t.setVisibility(view.VISIBLE);
            t.setText("0");
        });
        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);
        for (Button b: nums){
            b.setOnClickListener(
                    view -> {
                        if (!t.getText().toString().equals("0")){
                            t.setText(t.getText().toString() + b.getText().toString());

                        }else{
                            t.setText(b.getText().toString());
                        }
                    }
            );
        }
        ArrayList<Button> opers = new ArrayList<>();
        opers.add(div);
        opers.add(mul);
        opers.add(add);
        opers.add(soutra);
        for (Button b:opers){
            b.setOnClickListener(view ->
            {
                firstnum = Double.parseDouble(t.getText().toString());
                operation = b.getText().toString();
                t.setText("0");
            });
        }
        del.setOnClickListener(view ->
        {
            String num = t.getText().toString();
            if ( num.length()>1){
                t.setText(num.substring(0, num.length()-1));
            }else if (num.length() == 1 && !num.equals("0")){
                t.setText("0");
            }

        });
        point.setOnClickListener(view -> {
            if (!t.getText().toString().contains(".")) {
                t.setText(t.getText().toString() + ".");
            }
        });
         eg.setOnClickListener(view -> {
             secondnum =  Double.parseDouble(t.getText().toString());
             switch (operation){
                 case "/":
                     result = firstnum/secondnum;
                     break;
                 case "*":
                     result = firstnum*secondnum;
                     break;
                 case "+":
                     result = firstnum+secondnum;
                     break;
                 case "-":
                     result = firstnum-secondnum;
                     break;
                 default:
                     result = firstnum+secondnum;
             }
             t.setText(String.valueOf(result));
             firstnum = result;

         });






    }
}