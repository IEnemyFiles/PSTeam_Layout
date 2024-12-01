package ps.team;

import android.app.AlertDialog;
import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: ps.team.FloatingViewService */
public class FloatingViewService extends Service {
    private Button btnIconeInvisivel;
    
    private Button btnMostrarLogs;
   
	private Button btnShareLogs;
 
	CanvasView canvasLayout;

	WindowManager.LayoutParams canvasLayoutParams;
 
	private ImageView close_btn;
  
	public RelativeLayout collapse_view;
  
	private ImageView customAir;
  
	float density;
  
	int dpi;

    private EditText edtMostrarLogs;
  
	public LinearLayout expanded_container;
 
	public FrameLayout frameLayout;
  
	
	
    private LinearLayout ll_mostrarLogs;
    public WindowManager mEspWindowManager;
 

    public WindowManager mWindowManager;
    WindowManager.LayoutParams menuPSparams;
    int screenHeight;
    int screenWidth;
    long sleepTime = 16;
    int type;

    
    public IBinder onBind(Intent intent) {
        return null;
    }

    

    private class CanvasView extends View {
        public CanvasView(Context context) {
            super(context);
        }

        
        
    }

    private void setupMenu() {
        this.frameLayout = new FrameLayout(this);
       
		this.frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      
		this.customAir = new ImageView(this);
   
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m6dp(40), m6dp(40));
        layoutParams.topMargin = m6dp(18);
        this.customAir.setLayoutParams(layoutParams);
    
		RelativeLayout relativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        relativeLayout.setLayoutParams(layoutParams2);
        this.collapse_view = new RelativeLayout(this);
        this.collapse_view.setLayoutParams(layoutParams2);
    
		ImageView imageView = new ImageView(this);
        this.close_btn = new ImageView(this);
      
		LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(m6dp(60), m6dp(60));
        layoutParams3.topMargin = m6dp(15);
    
		LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(m6dp(15), m6dp(15));
        layoutParams4.leftMargin = m6dp(55);
        layoutParams4.topMargin = m6dp(10);
        imageView.setLayoutParams(layoutParams3);
        imageView.setImageDrawable(PSTeamMods.ps_icon(this, PSTeamMods.PATOLINOBR()));
    
		this.close_btn.setLayoutParams(layoutParams4);
        this.close_btn.setImageDrawable(PSTeamMods.ps_icon(this, PSTeamMods.SCOTT()));
        this.collapse_view.addView(imageView);
        this.collapse_view.addView(this.close_btn);
        this.expanded_container = new LinearLayout(this);
        this.expanded_container.setLayoutParams(new LinearLayout.LayoutParams(m6dp(200), -2));
        this.expanded_container.setOrientation(1);
        this.expanded_container.setBackgroundColor(Color.parseColor("#414040"));
        this.expanded_container.setVisibility(8);
     
		LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m6dp(30)));
        linearLayout.setGravity(5);
    
		LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(m6dp(200), -2));
        linearLayout2.setBackgroundColor(Color.parseColor("#292828"));
        linearLayout2.setOrientation(1);
   
		LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.setOrientation(0);
        linearLayout3.setPadding(m6dp(8), m6dp(8), m6dp(8), m6dp(8));
 
		ImageView imageView2 = new ImageView(this);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(m6dp(40), m6dp(40)));
        imageView2.setImageDrawable(PSTeamMods.ps_icon(this, PSTeamMods.PATOLINOBR()));
   
		TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        layoutParams5.leftMargin = m6dp(10);
        textView.setLayoutParams(layoutParams5);
        textView.setText("Mod Menu by \nMusk Mods");
        linearLayout3.addView(imageView2);
        linearLayout3.addView(textView);
        textView.setTextColor(Color.parseColor("RED"));
   
		ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, m6dp(152)));
    
		LinearLayout linearLayout4 = new LinearLayout(this);
        linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout4.setOrientation(1);
    
		LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, m6dp(35));
        layoutParams6.topMargin = m6dp(5);
        layoutParams6.leftMargin = m6dp(5);
        layoutParams6.rightMargin = m6dp(5);
        int parseColor = Color.parseColor("#ffffff");
    
		new LinearLayout.LayoutParams(-2, m6dp(33)).rightMargin = m6dp(5);
        Color.parseColor("#ffffff");
    
		LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, m6dp(40));
        layoutParams7.topMargin = m6dp(5);
        layoutParams7.leftMargin = m6dp(5);
        layoutParams7.rightMargin = m6dp(5);
  
		LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.leftMargin = m6dp(5);
        layoutParams8.rightMargin = m6dp(5);
    
		    
		this.btnIconeInvisivel = new Button(this);
        this.btnIconeInvisivel.setLayoutParams(layoutParams6);
        this.btnIconeInvisivel.setTextSize(12.0f);
        this.btnIconeInvisivel.setTypeface((Typeface) null, 1);
        this.btnIconeInvisivel.setBackground(PSTeamMods.botoes(this));
        this.btnIconeInvisivel.setTextColor(parseColor);
        this.btnIconeInvisivel.setText("Icon Invisible");
   
		linearLayout4.addView(this.btnIconeInvisivel);
		
		TextView textView2 = new TextView(this);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.gravity = 17;
        layoutParams9.topMargin = m6dp(12);
        layoutParams9.bottomMargin = m6dp(12);
    
		textView2.setLayoutParams(layoutParams9);
        textView2.setTypeface(Typeface.MONOSPACE, 1);
        textView2.setText("Free Fire v1.62");
        textView2.setTextColor(Color.parseColor("#FFFFFF"));
    
		LinearLayout linearLayout5 = new LinearLayout(this);
        linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout5.setOrientation(0);
    
		LinearLayout linearLayout6 = new LinearLayout(this);
        linearLayout6.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout6.setWeightSum(1.0f);
   
	    Button btnClose = new Button(this);
           btnClose.setLayoutParams(new LinearLayout.LayoutParams(-2, m6dp(33)));
        btnClose.setTextSize(2, 10.0f);
        btnClose.setTypeface((Typeface) null, 1);
        btnClose.setBackgroundColor(Color.parseColor("RED"));
        btnClose.setTextColor(parseColor);
        btnClose.setText("CLOSE");
   
		linearLayout6.addView(btnClose);
  
		LinearLayout linearLayout7 = new LinearLayout(this);
        linearLayout7.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout7.setWeightSum(1.0f);
        this.btnMostrarLogs = new Button(this);
    
		LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, m6dp(33));
        layoutParams10.leftMargin = m6dp(24);
        this.btnMostrarLogs.setLayoutParams(layoutParams10);
        this.btnMostrarLogs.setTextSize(2, 10.0f);
        this.btnMostrarLogs.setTypeface((Typeface) null, 1);
        this.btnMostrarLogs.setBackgroundColor(Color.parseColor("RED"));
        this.btnMostrarLogs.setTextColor(parseColor);
        this.btnMostrarLogs.setText("LOGS");
   
		linearLayout7.addView(this.btnMostrarLogs);
     
		linearLayout5.addView(linearLayout6);
     
		linearLayout5.addView(linearLayout7);
   
		scrollView.addView(linearLayout4);
  
		linearLayout2.addView(linearLayout3);
 
		linearLayout2.addView(scrollView);
  
		linearLayout2.addView(textView2);

        linearLayout2.addView(linearLayout5);

        this.ll_mostrarLogs = new LinearLayout(this);
        this.ll_mostrarLogs.setLayoutParams(new LinearLayout.LayoutParams(m6dp(220), -2));
        this.ll_mostrarLogs.setBackgroundColor(Color.parseColor("#201C1C"));
        this.ll_mostrarLogs.setOrientation(1);
        this.ll_mostrarLogs.setPadding(m6dp(10), m6dp(10), m6dp(10), m6dp(10));
        this.ll_mostrarLogs.setVisibility(8);
 
		LinearLayout linearLayout8 = new LinearLayout(this);
        linearLayout8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout8.setOrientation(0);
        linearLayout8.setPadding(m6dp(8), m6dp(8), m6dp(8), m6dp(8));
  
		ImageView imageView3 = new ImageView(this);
        imageView3.setLayoutParams(new LinearLayout.LayoutParams(m6dp(40), m6dp(40)));
        imageView3.setImageDrawable(PSTeamMods.ps_icon(this, PSTeamMods.PATOLINOBR()));
  
		TextView textView3 = new TextView(this);
 
		LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.gravity = 17;
        layoutParams11.leftMargin = m6dp(10);
        textView3.setLayoutParams(layoutParams11);
        textView3.setTextColor(Color.parseColor("RED"));
        textView3.setText("Mod Menu by \nMusk Mods");
    
		linearLayout8.addView(imageView3);
   
		linearLayout8.addView(textView3);
  
		this.ll_mostrarLogs.addView(linearLayout8);
    
		this.edtMostrarLogs = new EditText(this);
        this.edtMostrarLogs.setLayoutParams(new LinearLayout.LayoutParams(-1, m6dp(200)));
        this.edtMostrarLogs.setMaxLines(12);
        this.edtMostrarLogs.setTextSize(2, 11.0f);
        this.edtMostrarLogs.setGravity(48);
        this.edtMostrarLogs.setTextColor(Color.parseColor("#ffffff"));
        this.edtMostrarLogs.setVerticalScrollBarEnabled(true);
        this.ll_mostrarLogs.addView(this.edtMostrarLogs);
 
		LinearLayout linearLayout9 = new LinearLayout(this);
        linearLayout9.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout9.setOrientation(0);
   
		Button btnCloseMostrarLogs = new Button(this);

        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, m6dp(33));
        layoutParams12.topMargin = m6dp(6);
        btnCloseMostrarLogs.setLayoutParams(layoutParams12);
        btnCloseMostrarLogs.setTextSize(2, 10.0f);
        btnCloseMostrarLogs.setTypeface((Typeface) null, 1);
        btnCloseMostrarLogs.setBackgroundColor(Color.parseColor("RED"));
        btnCloseMostrarLogs.setTextColor(parseColor);
        btnCloseMostrarLogs.setText("CLOSE");
   
		this.btnShareLogs = new Button(this);
   
		LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, m6dp(33));
        layoutParams13.leftMargin = m6dp(20);
        layoutParams13.topMargin = m6dp(6);
  
		this.btnShareLogs.setLayoutParams(layoutParams13);
        this.btnShareLogs.setTextSize(2, 10.0f);
        this.btnShareLogs.setTypeface((Typeface) null, 1);
        this.btnShareLogs.setBackgroundColor(Color.parseColor("RED"));
        this.btnShareLogs.setTextColor(parseColor);
   
		this.btnShareLogs.setText("CO0Y LOGS");
   
		linearLayout9.addView(btnCloseMostrarLogs);
    
		linearLayout9.addView(this.btnShareLogs);
    
		this.ll_mostrarLogs.addView(linearLayout9);
    
		this.expanded_container.addView(linearLayout2);
 
		relativeLayout.addView(this.collapse_view);
   
		relativeLayout.addView(this.expanded_container);
   
		relativeLayout.addView(this.ll_mostrarLogs);
      
		this.frameLayout.addView(relativeLayout);
		btnClose.setOnClickListener(new View.OnClickListener() {
				public final void onClick(View view) {
					FloatingViewService.this.lambda$initFloating$1$FloatingViewService(view);
				}
			});
		btnCloseMostrarLogs.setOnClickListener(new View.OnClickListener() {
				public final void onClick(View view) {
					FloatingViewService.this.lambda$initFloating$2$FloatingViewService(view);
				}
			});
		
    }

    public void onCreate() {
        super.onCreate();
     
		setupMenu();
       
		this.collapse_view.setAlpha(0.8f);
        this.expanded_container.setAlpha(0.8f);
   
		this.menuPSparams = new WindowManager.LayoutParams(-2, -2, Build.VERSION.SDK_INT > 25 ? 2038 : 2002, 8200, -3);
    
		WindowManager.LayoutParams layoutParams = this.menuPSparams;
        layoutParams.gravity = 8388659;
        layoutParams.x = 0;
        layoutParams.y = 100;
     
		this.mWindowManager = (WindowManager) getSystemService("window");
        this.mWindowManager.addView(this.frameLayout, this.menuPSparams);
        this.mEspWindowManager = (WindowManager) getSystemService("window");
   
		    
		
        
        initFloating();
    }

    private void initFloating() {
        this.close_btn.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FloatingViewService.this.lambda$initFloating$0$FloatingViewService(view);
            }
        });
        
        this.btnMostrarLogs.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FloatingViewService.this.lambda$initFloating$3$FloatingViewService(view);
            }
        });
        this.btnShareLogs.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FloatingViewService.this.lambda$initFloating$4$FloatingViewService(view);
            }
        });
        this.frameLayout.setOnTouchListener(new View.OnTouchListener() {
            private float initialTouchX;
            private float initialTouchY;
            private int initialX;
            private int initialY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.initialX = FloatingViewService.this.menuPSparams.x;
                    this.initialY = FloatingViewService.this.menuPSparams.y;
                    this.initialTouchX = motionEvent.getRawX();
                    this.initialTouchY = motionEvent.getRawY();
                    if ((FloatingViewService.this.menuPSparams.flags & 8192) != 8192) {
                        WindowManager.LayoutParams layoutParams = FloatingViewService.this.menuPSparams;
                        layoutParams.flags = 8192 | layoutParams.flags;
                    }
                    FloatingViewService.this.collapse_view.setAlpha(0.8f);
                    FloatingViewService.this.expanded_container.setAlpha(0.8f);
                    return true;
                } else if (action == 1) {
                    int rawX = (int) (motionEvent.getRawX() - this.initialTouchX);
                    int rawY = (int) (motionEvent.getRawY() - this.initialTouchY);
                    FloatingViewService.this.collapse_view.setAlpha(0.8f);
                    FloatingViewService.this.expanded_container.setAlpha(0.8f);
                    if (rawX < 10 && rawY < 10 && FloatingViewService.this.isViewCollapsed()) {
                        FloatingViewService.this.collapse_view.setVisibility(8);
                        FloatingViewService.this.expanded_container.setVisibility(0);
                    }
                    return true;
                } else if (action != 2) {
                    return false;
                } else {
                    FloatingViewService.this.menuPSparams.x = this.initialX + ((int) (motionEvent.getRawX() - this.initialTouchX));
                    FloatingViewService.this.menuPSparams.y = this.initialY + ((int) (motionEvent.getRawY() - this.initialTouchY));
                    FloatingViewService.this.mWindowManager.updateViewLayout(FloatingViewService.this.frameLayout, FloatingViewService.this.menuPSparams);
                    return true;
                }
            }
        });
        
        this.btnIconeInvisivel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FloatingViewService.this.collapse_view.setVisibility(0);
                FloatingViewService.this.expanded_container.setVisibility(8);
                FloatingViewService.this.collapse_view.setAlpha(0.0f);
                FloatingViewService.this.menuPSparams.gravity = 51;
                FloatingViewService.this.menuPSparams.x = 0;
                FloatingViewService.this.menuPSparams.y = 48;
                FloatingViewService.this.menuPSparams.flags &= -8193;
                FloatingViewService.this.mWindowManager.updateViewLayout(FloatingViewService.this.frameLayout, FloatingViewService.this.menuPSparams);
            }
        });
    }

    public /* synthetic */ void lambda$initFloating$0$FloatingViewService(View view) {
        AlertDialog create = new AlertDialog.Builder(getBaseContext()).setMessage("\n\tDeseja fechar?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                FloatingViewService.this.stopSelf();
            }
        }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).create();
        create.getWindow().setType(Build.VERSION.SDK_INT > 25 ? 2038 : 2002);
        create.show();
    }

    public /* synthetic */ void lambda$initFloating$1$FloatingViewService(View view) {
        this.collapse_view.setVisibility(0);
        this.expanded_container.setVisibility(8);
    }

    public /* synthetic */ void lambda$initFloating$2$FloatingViewService(View view) {
        this.ll_mostrarLogs.setVisibility(8);
        this.expanded_container.setVisibility(0);
    }

    public /* synthetic */ void lambda$initFloating$3$FloatingViewService(View view) {
        this.expanded_container.setVisibility(8);
        this.ll_mostrarLogs.setVisibility(0);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getApplicationContext().getExternalFilesDir((String) null).getPath().concat("/psteamlogs.txt")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.edtMostrarLogs.setText(sb.toString());
    }

    public /* synthetic */ void lambda$initFloating$4$FloatingViewService(View view) {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Logs", this.edtMostrarLogs.getText().toString()));
        Toast.makeText(getApplicationContext(), "Copiado para área de transferência", 0).show();
    }

    /* access modifiers changed from: private */
    public boolean isViewCollapsed() {
        return this.frameLayout == null || this.collapse_view.getVisibility() == 0;
    }

    public void onDestroy() {
        super.onDestroy();
        FrameLayout frameLayout2 = this.frameLayout;
        if (frameLayout2 != null) {
            this.mWindowManager.removeView(frameLayout2);
        }
    }

    /* renamed from: dp */
    private int m6dp(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    private int getLayoutType() {
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return 2002;
        }
        return Build.VERSION.SDK_INT >= 23 ? 2005 : 2003;
    }

    private static byte[] Hex2b(String str) {
        if (str.contains(" ")) {
            str = str.replace(" ", "");
        }
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
            }
            return bArr;
        } else {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
    }

    private static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    /* access modifiers changed from: private */
    public static void write(int i, String str) {
        if (new File("/storage/emulated/0/Android/data/com.dts.freefireth/files/contentcache/Compulsory/android/gameassetbundles/avatar/assetindexer.ChmtrFErUImPUvnstlQ98bJ4L9I~3D").exists()) {
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = new RandomAccessFile("/storage/emulated/0/Android/data/com.dts.freefireth/files/contentcache/Compulsory/android/gameassetbundles/avatar/assetindexer.ChmtrFErUImPUvnstlQ98bJ4L9I~3D", "rw");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                randomAccessFile.seek((long) i);
                randomAccessFile.write(Hex2b(str));
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        onTaskRemoved(intent);
        return 2;
    }

    public void onTaskRemoved(Intent intent) {
        Intent intent2 = new Intent(getApplicationContext(), getClass());
        intent2.setPackage(getPackageName());
        startService(intent2);
        super.onTaskRemoved(intent);
    }

    private int getResID(String str, String str2) {
        return getResources().getIdentifier(str, str2, getPackageName());
    }

    private int getId(String str) {
        return getResID(str, "id");
    }

    private int getLayout(String str) {
        return getResID(str, "layout");
    }

    private int getDrawable(String str) {
        return getResID(str, "drawable");
    }
}
