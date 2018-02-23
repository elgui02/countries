package u.paises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Language extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
    }

    public void onBtnEsClick(View view)
    {
        Intent show = new Intent(Language.this, EsActivity.class);
        startActivity(show);
    }
}
