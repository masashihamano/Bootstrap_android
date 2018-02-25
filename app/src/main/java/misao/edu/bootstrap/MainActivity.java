package misao.edu.bootstrap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.beardedhen.androidbootstrap.AwesomeTextView;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.beardedhen.androidbootstrap.BootstrapLabel;
import com.beardedhen.androidbootstrap.BootstrapProgressBar;
import com.beardedhen.androidbootstrap.BootstrapText;


public class MainActivity extends AppCompatActivity {

    private AwesomeTextView awesomeTextView;
    private BootstrapText.Builder builder;
    private BootstrapText bootstrapText1, bootstrapText2;
    private boolean flg =true;

    private BootstrapLabel bsLabel;
    private BootstrapEditText bsEditText;
    private BootstrapProgressBar bsProgressBar1,bsProgressBar2;
    int progA, progB =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //BootstrapText.Builder
        builder = new BootstrapText.Builder( getApplicationContext(),true );

        //AwesomeTexitView
        awesomeTextView = findViewById( R.id.awesome_textview );
        BootstrapButton bsButton = findViewById(R.id.bootstrap_button);

        //リスナーをボタンに登録
        bsButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flg){
                    builder = new BootstrapText.Builder( getApplicationContext(),true );
                    bootstrapText1 = builder.addFontAwesomeIcon( "fa_check_square" ).addText( "チェック" ).build();
                    flg = false;
                } else{
                    builder = new BootstrapText.Builder( getApplicationContext(),true );
                    bootstrapText1 = builder.addText("Awesome ").addFontAwesomeIcon( "fa_heart" ).build();
                    flg = true;
                }
                awesomeTextView.setBootstrapText( bootstrapText1 );

            }
        } );

        //BootstrapLabel
        bsLabel = findViewById( R.id.bootstrap_label );

        BootstrapButton bsButton1 = findViewById( R.id.bootstrap_button1 );
        bsButton1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bsLabel.setText( R.string.label1 );
            }
        } );

        BootstrapButton bsButton2 = findViewById( R.id.bootstrap_button2 );
        bsButton2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bsLabel.setText( R.string.label2 );

            }
        } );

        //BootstrapEditText
        bsEditText = findViewById( R.id.bootstrap_edittext );

        Button button = findViewById( R.id.button );
        button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String str = bsEditText.getText().toString();
                bsLabel.setText( str );
            }
        });

        //BootstrapProgressBar
        bsProgressBar1 = findViewById( R.id.bootstrap_progressbar1 );
        bsProgressBar2 = findViewById( R.id.bootstrap_progressbar2 );

        //SeekBar
        SeekBar seekBar = findViewById( R.id.seekbar );
        seekBar.setProgress(0);
        seekBar.setMax( 100 );
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar, int progress, boolean fromUser) {
                        progA = progress;
                        progB = progress / 2;

                        if (progA + progB <= 100) {
                            bsProgressBar1.setProgress( progA );
                            bsProgressBar2.setProgress( progB );

                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }

                }
        );

    }
}
