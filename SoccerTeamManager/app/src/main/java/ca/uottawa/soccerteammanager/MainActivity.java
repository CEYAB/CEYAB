package ca.uottawa.soccerteammanager;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnOpenInGoogleMaps (View view) {
        EditText teamAddress = (EditText) findViewById(R.id.teamAddressField);
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddress.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivityForResult (intent,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;
        ImageView avatarImage = (ImageView) findViewById(R.id.logoImage);

        String drawableName = "fcb"; //4
        switch (data.getIntExtra("imageID",R.id.logoImage)) {//Figuring out the correct image
            case R.id.logoImage:
                drawableName = "FC Barcalona";
                break;
            case R.id.imageView2:
                drawableName = "FC Chelsea";
                break;
            case R.id.imageView3:
                drawableName = "Man United";
                break;
            case R.id.imageView4:
                drawableName = "Paris saint-german";
                break;
            case R.id.imageView5:
                drawableName = "Real Madrid";
                break;
            case R.id.imageView6:
                drawableName = "FC Football";
                break;
            default:
                drawableName = "FC Barcalona";
                break;
        } //27
        int resID = getResources().getIdentifier(drawableName, "drawable",  getPackageName());
        avatarImage.setImageResource(resID);
    }
}
