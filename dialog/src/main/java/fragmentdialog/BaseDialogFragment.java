package fragmentdialog;

/**
 * @author DKV.
 */
public abstract class BaseDialogFragment extends BaseFragment {

    public abstract BaseDialogFragment setContent(String content, String okText, String cancelText, String exitText, String dialogTitle);

    public abstract int buttonCount();


}
