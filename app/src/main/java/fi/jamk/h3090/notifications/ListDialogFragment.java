package fi.jamk.h3090.notifications;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Crowmoore on 26-Sep-16.
 */
public class ListDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.list_dialog_title)
                .setItems(R.array.message_types, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int index) {
                        Resources res = getResources();
                        String[] messageTypes = res.getStringArray(R.array.message_types);
                        Toast.makeText(getActivity(), "List dialog selection: " + messageTypes[index], Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
