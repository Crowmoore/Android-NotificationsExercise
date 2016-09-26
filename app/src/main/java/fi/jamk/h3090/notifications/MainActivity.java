package fi.jamk.h3090.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int publicNotificationID = 1;
    private int privateNotificationID = 2;
    private int secretNotificationID = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.first_item:
                Toast.makeText(getBaseContext(), "First item selected", Toast.LENGTH_SHORT).show();
            case R.id.second_item:
                Toast.makeText(getBaseContext(), "Second item selected", Toast.LENGTH_SHORT).show();
            default: super.onOptionsItemSelected(item);
        }
        return false;
    }

    public void openExitDialog(View view) {
        ExitDialogFragment dialog = new ExitDialogFragment();
        dialog.show(getFragmentManager(), "Exit");
    }

    public void openListDialog(View view) {
        ListDialogFragment dialog = new ListDialogFragment();
        dialog.show(getFragmentManager(), "");
    }

    public void notifyButtonClicked(View view) {
        RadioGroup group = (RadioGroup) findViewById(R.id.notifications_group);
        int selectedID = group.getCheckedRadioButtonId();
        RadioButton button = (RadioButton) findViewById(selectedID);
        String selectedText = (String) button.getText();

        switch(selectedText) {
            case "Public notification": sendPublicNotification(); break;
            case "Private notification": sendPrivateNotification(); break;
            case "Secret notification": sendSecretNotification(); break;
        }
    }

    private void sendPublicNotification() {
        Notification notification = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Public notification")
                .setContentText("This is a public notification")
                .setSmallIcon(R.drawable.icon)
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_PUBLIC).build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(publicNotificationID, notification);
    }

    private void sendPrivateNotification() {
        Notification notification = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Private notification")
                .setContentText("This is a private notification")
                .setSmallIcon(R.drawable.icon)
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_PRIVATE).build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(privateNotificationID, notification);
    }

    private void sendSecretNotification() {
        Notification notification = new Notification.Builder(this)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Secret notification")
                .setContentText("This is a secret notification")
                .setSmallIcon(R.drawable.icon)
                .setAutoCancel(true)
                .setVisibility(Notification.VISIBILITY_SECRET).build();
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(secretNotificationID, notification);
    }

}
