package ps.team;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Random;
public class MainActivity extends Activity {
    private static final String TAG = "musk";
    public String GameActivity = "com.dts.freefireth.FFMainActivity";
    String[] PERMISSIONS = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE"};
    int PERMISSION_ALL = 1;
    private AlertDialog alertBuilder = null;
    
	private SharedPreferences.Editor editor = null;

    public LinearLayout ll_progress = null;
        private SharedPreferences preferences = null;

  

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
            startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + getPackageName())), 123);
            finish();
        }
        this.preferences = getSharedPreferences("psteam", 0);
    
		this.editor = this.preferences.edit();
     
		View dialog_login_nexus = dialog_login_nexus();
     
		this.ll_progress = (LinearLayout) dialog_login_nexus.findViewWithTag("ll_progress");
    
		this.alertBuilder = new AlertDialog.Builder(this).setView(dialog_login_nexus).setCancelable(false).create();
        this.alertBuilder.getWindow().setFlags(8192, 8192);
        this.alertBuilder.show();
    
		EditText editText = (EditText) dialog_login_nexus.findViewWithTag("edtUsuario");
   
		EditText editText2 = (EditText) dialog_login_nexus.findViewWithTag("edtSenha");
     
		CheckBox checkBox = (CheckBox) dialog_login_nexus.findViewWithTag("cbLembrar");
     
		editText.setText(this.preferences.getString("usuario", "musk"));
    
		editText2.setText(this.preferences.getString("senha", "musk"));
    
		checkBox.setChecked(this.preferences.getBoolean("lembrar", false));
    

     
      }  

    
    public void showAlert(String str) {
        new AlertDialog.Builder(this).setIcon(PSTeamMods.ps_icon(this, PSTeamMods.PATOLINOBR())).setTitle("Falha ao tentar acessar o app").setMessage(str).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.lambda$showAlert$24$MainActivity(dialogInterface, i);
            }
        }).create().show();
    }

    public /* synthetic */ void lambda$showAlert$24$MainActivity(DialogInterface dialogInterface, int i) {
        this.ll_progress.setVisibility(8);
        dialogInterface.dismiss();
    }

    private View dialog_login_nexus() {
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
     
	    LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setBackgroundColor(Color.parseColor("#292828"));
        linearLayout.setOrientation(1);
   
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m7dp(40), m7dp(40));
        layoutParams.gravity = 5;
    
		Button button = new Button(this);
        button.setTag("btnFechar");
        button.setLayoutParams(layoutParams);
        button.setText("X");
        button.setBackgroundColor(Color.parseColor("#05DDFF"));
        button.setTextColor(Color.parseColor("#ffffff"));
        button.setTypeface((Typeface) null, 1);
        button.setTextSize(2, 20.0f);
        
        TextView textView = new TextView(this);
 
		LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams(layoutParams2);
        textView.setText("PSTeam");
        textView.setTextSize(2, 20.0f);
        textView.setTypeface((Typeface) null, 1);
        textView.setTextColor(Color.parseColor("#05DDFF"));
   
		EditText editText = new EditText(this);
        editText.setTag("edtUsuario");
        editText.setHint("Usuário");
        editText.setTextColor(Color.parseColor("#ffffff"));
        editText.setHintTextColor(Color.parseColor("#ffffff"));
    
		LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMarginStart(m7dp(8));
        layoutParams3.topMargin = m7dp(16);
        layoutParams3.setMarginEnd(m7dp(8));
        editText.setLayoutParams(layoutParams3);
   
		EditText editText2 = new EditText(this);
        editText2.setTag("edtSenha");
        editText2.setHint("Senha");
        editText2.setTextColor(Color.parseColor("#ffffff"));
        editText2.setHintTextColor(Color.parseColor("#ffffff"));
        layoutParams3.setMarginStart(m7dp(8));
        layoutParams3.topMargin = m7dp(16);
        layoutParams3.setMarginEnd(m7dp(8));
        editText2.setLayoutParams(layoutParams3);
   
		LinearLayout linearLayout2 = new LinearLayout(this);
   
		LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.weight = 1.0f;
        linearLayout2.setLayoutParams(layoutParams4);
  
		CheckBox checkBox = new CheckBox(this);
        checkBox.setTag("cbLembrar");
    
		LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.setMargins(m7dp(8), m7dp(8), 0, m7dp(8));
        checkBox.setLayoutParams(layoutParams5);
        checkBox.setText("Lembrar");
        checkBox.setTextColor(Color.parseColor("#05DDFF"));
        checkBox.setChecked(true);
        linearLayout2.addView(checkBox);
    
		LinearLayout linearLayout3 = new LinearLayout(this);
   
		LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.weight = 1.0f;
        linearLayout3.setLayoutParams(layoutParams6);
        linearLayout3.setOrientation(1);
    
		Button button2 = new Button(this);
        button2.setTag("btnEntrar");
  
		LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, m7dp(40));
        layoutParams7.gravity = 5;
        layoutParams7.weight = 1.0f;
        layoutParams7.topMargin = m7dp(8);
        layoutParams7.rightMargin = m7dp(8);
        layoutParams7.bottomMargin = m7dp(8);
   
		button2.setLayoutParams(layoutParams7);
        button2.setText("Entrar");
        button2.setTextColor(Color.parseColor("#05DDFF"));
        button2.setTextSize(2, 12.0f);
        button2.setBackground(PSTeamMods.botoes(this));
        button2.setTypeface((Typeface) null, Typeface.MONOSPACE.getStyle());
		button2.setOnClickListener(new View.OnClickListener() {
				public final void onClick(View view) {
					
					
					
					String format = ("Usuário: musk\nValidade: 99/99/9999");
					startMenu("musk" ,format);
				}
			});
		
		linearLayout3.addView(button2);
        linearLayout.addView(button);
        linearLayout.addView(textView);
        linearLayout.addView(editText);
        linearLayout.addView(editText2);
        linearLayout.addView(linearLayout2);
        linearLayout.addView(linearLayout3);
     
		LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setTag("ll_progress");
    
		LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout4.setVisibility(8);
        linearLayout4.setBackgroundColor(Color.parseColor("#99FFFFFF"));
        linearLayout4.setOrientation(1);
        linearLayout4.setGravity(17);
        linearLayout4.setClickable(true);
        linearLayout4.setLayoutParams(layoutParams8);
    
		ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout4.addView(progressBar);
        frameLayout.addView(linearLayout);
        frameLayout.addView(linearLayout4);
        return frameLayout;
    }

    

    private int m7dp(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

   public void showInfoUser(String str) {
        new AlertDialog.Builder(this).setIcon(PSTeamMods.ps_icon(this, PSTeamMods.PATOLINOBR())).setTitle("Informações do usuário").setMessage(str).setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.musk(dialogInterface, i);
            }
        }).create().show();
    }

    public void musk(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this, FloatingViewService.class);
        try {
            startActivity(new Intent(this, Class.forName(this.GameActivity)));
            startService(intent);
        } catch (ClassNotFoundException e) {
            startService(new Intent(this, FloatingViewService.class));
            e.printStackTrace();
        }
    }

     public void startMenu(String str, String str2) {
        this.alertBuilder.dismiss();
        
        showInfoUser(str2);
    }

    private String gerarIMEI() {
        String str = GenerateRandomNumber(7) + GenerateRandomNumber(7);
        return str + getCheckDigit(str);
    }

    private String GenerateRandomNumber(int i) {
        int i2;
        if (i < 1) {
            i2 = 0;
        } else {
            double d = (double) (i - 1);
            i2 = new Random().nextInt((((int) Math.pow(10.0d, d)) * 9) - 1) + ((int) Math.pow(10.0d, d));
        }
        return String.valueOf(i2);
    }

    private int getCheckDigit(String str) {
        int i = 0;
        for (int i2 = 13; i2 >= 0; i2--) {
            int intValue = Integer.valueOf(str.substring(i2, i2 + 1)).intValue();
            if (i2 % 2 != 0) {
                intValue = sumUpDigits(intValue);
            }
            i += intValue;
        }
        return (i * 9) % 10;
    }

    private int sumUpDigits(int i) {
        int i2 = 0;
        for (int i3 = i * 2; i3 > 0; i3 /= 10) {
            i2 += i3 % 10;
        }
        return i2;
    }

 
    
}
