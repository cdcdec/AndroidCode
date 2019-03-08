package afollestad
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.Color.TRANSPARENT
import android.graphics.Point
import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.assent.Permission.READ_EXTERNAL_STORAGE
import com.afollestad.assent.Permission.WRITE_EXTERNAL_STORAGE
import com.afollestad.assent.runWithPermissions
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.callbacks.onCancel
import com.afollestad.materialdialogs.callbacks.onDismiss
import com.afollestad.materialdialogs.callbacks.onShow
import com.afollestad.materialdialogs.checkbox.checkBoxPrompt
import com.afollestad.materialdialogs.customview.customView
import com.afollestad.materialdialogs.customview.getCustomView
import com.afollestad.materialdialogs.list.listItems
import com.afollestad.materialdialogs.list.listItemsMultiChoice
import com.afollestad.materialdialogs.list.listItemsSingleChoice
import com.afollestad.materialdialogs.input.input
import com.afollestad.materialdialogs.files.fileChooser
import com.afollestad.materialdialogs.files.folderChooser
import com.afollestad.materialdialogs.color.ColorPalette
import com.afollestad.materialdialogs.color.colorChooser
import com.cdc.dialog.R
import kotlinx.android.synthetic.main.afollestad_activity_main.*
import android.view.WindowManager
import android.view.Gravity
/** @author Aidan Follestad (afollestad) */
class AfollestadDialogActivity : AppCompatActivity() {

  companion object {
    const val KEY_PREFS = "prefs"
    const val KEY_THEME = "KEY_THEME"
    const val KEY_DEBUG_MODE = "debug_mode"

    const val LIGHT = "light"
    const val DARK = "dark"
    const val CUSTOM = "custom"
  }

  private var debugMode = false
  private lateinit var prefs: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    prefs = getSharedPreferences(KEY_PREFS, MODE_PRIVATE)
    setTheme(
        when (prefs.getString(KEY_THEME, LIGHT)) {
          DARK -> R.style.AppTheme_Dark
          CUSTOM -> R.style.AppTheme_Custom
          else -> R.style.AppTheme
        }
    )
    debugMode = prefs.boolean(KEY_DEBUG_MODE, false)

    super.onCreate(savedInstanceState)
    setContentView(R.layout.afollestad_activity_main)

    basic.setOnClickListener {
      var dia=MaterialDialog(this)
      val window = dia.window
      var windowManager=windowManager
      var display=windowManager.defaultDisplay
      var  params = window.attributes
      var point=Point()
      display.getSize(point)
      params.height=point.y/2  // 高度设置为屏幕的0.5
      params.width=point.x   // 宽度设置为屏幕的宽度
      Log.e("111","x=${point.x},y=${point.y/2}")
      params.flags=WindowManager.LayoutParams.FLAG_DIM_BEHIND
      params.gravity=Gravity.BOTTOM
      window.attributes=params
      dia.show {
        message(R.string.shareLocationPrompt)
        debugMode(debugMode)
      }
    }

    basic_titled.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        message(R.string.useGoogleLocationServicesPrompt)
        debugMode(debugMode)
      }
    }

    basic_buttons.setOnClickListener {
      MaterialDialog(this).show {
        message(R.string.useGoogleLocationServicesPrompt)
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    basic_titled_buttons.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        message(R.string.useGoogleLocationServicesPrompt)
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    basic_html_content.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.app_name)
        message(
            R.string.htmlContent,
            html = true,
            lineHeightMultiplier = 1.4f
        )
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    basic_long.setOnClickListener {
      MaterialDialog(this).show {
        message(R.string.loremIpsum)
        debugMode(debugMode)
      }
    }

    basic_long_titled_buttons.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        message(R.string.loremIpsum)
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    basic_icon.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        icon(R.mipmap.ic_launcher)
        message(R.string.useGoogleLocationServicesPrompt)
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    basic_checkbox_titled_buttons.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        message(R.string.useGoogleLocationServicesPrompt)
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        checkBoxPrompt(R.string.checkboxConfirm) { checked ->
          toast("Checked? $checked")
        }
        debugMode(debugMode)
      }
    }

    list.setOnClickListener {
      MaterialDialog(this).show {
        listItems(R.array.socialNetworks) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        debugMode(debugMode)
      }
    }

    list_buttons.setOnClickListener {
      MaterialDialog(this).show {
        listItems(R.array.socialNetworks) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    list_titled.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItems(R.array.socialNetworks) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        debugMode(debugMode)
      }
    }

    list_titled_buttons.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItems(R.array.socialNetworks) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    list_titled_message_buttons.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        message(R.string.useGoogleLocationServices)
        listItems(R.array.socialNetworks) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    list_long.setOnClickListener {
      MaterialDialog(this).show {
        listItems(R.array.states) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        debugMode(debugMode)
      }
    }

    list_long_buttons.setOnClickListener {
      MaterialDialog(this).show {
        listItems(R.array.states) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    list_long_titled.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.states)
        listItems(R.array.states) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        debugMode(debugMode)
      }
    }

    list_long_titled_buttons.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.states)
        listItems(R.array.states) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    list_long_items.setOnClickListener {
      MaterialDialog(this).show {
        listItems(R.array.socialNetworks_longItems) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        debugMode(debugMode)
      }
    }

    list_long_items_buttons.setOnClickListener {
      MaterialDialog(this).show {
        listItems(R.array.socialNetworks_longItems) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    list_long_items_titled.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItems(R.array.socialNetworks_longItems) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        debugMode(debugMode)
      }
    }

    list_long_items_titled_buttons.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItems(R.array.socialNetworks_longItems) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    list_checkPrompt.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItems(R.array.socialNetworks_longItems) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        checkBoxPrompt(R.string.checkboxConfirm) { checked ->
          toast("Checked? $checked")
        }
        debugMode(debugMode)
      }
    }

    list_checkPrompt_buttons.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItems(R.array.socialNetworks_longItems) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        checkBoxPrompt(R.string.checkboxConfirm) { checked ->
          toast("Checked? $checked")
        }
        debugMode(debugMode)
      }
    }

    single_choice_titled.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItemsSingleChoice(R.array.socialNetworks, initialSelection = 1) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        debugMode(debugMode)
      }
    }

    single_choice_buttons_titled.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItemsSingleChoice(R.array.socialNetworks, initialSelection = 2) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.choose)
        debugMode(debugMode)
      }
    }

    single_choice_long_items.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItemsSingleChoice(R.array.socialNetworks_longItems) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.choose)
        debugMode(debugMode)
      }
    }

    single_choice_disabled_items.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItemsSingleChoice(
            R.array.socialNetworks, initialSelection = 1, disabledIndices = intArrayOf(1, 3)
        ) { _, index, text ->
          toast("Selected item $text at index $index")
        }
        positiveButton(R.string.choose)
        debugMode(debugMode)
      }
    }

    multiple_choice.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItemsMultiChoice(
            R.array.socialNetworks, initialSelection = intArrayOf(1, 3)
        ) { _, indices, text ->
          toast("Selected items ${text.joinToString()} at indices ${indices.joinToString()}")
        }
        debugMode(debugMode)
      }
    }

    multiple_choice_buttons.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItemsMultiChoice(
            R.array.socialNetworks, initialSelection = intArrayOf(1, 3)
        ) { _, indices, text ->
          toast("Selected items ${text.joinToString()} at indices ${indices.joinToString()}")
        }
        positiveButton(R.string.choose)
        debugMode(debugMode)
      }
    }

    multiple_choice_long_items.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItemsMultiChoice(
            R.array.socialNetworks_longItems, initialSelection = intArrayOf(0, 2)
        ) { _, indices, text ->
          toast("Selected items ${text.joinToString()} at indices ${indices.joinToString()}")
        }
        positiveButton(R.string.choose)
        debugMode(debugMode)
      }
    }

    multiple_choice_disabled_items.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.socialNetworks)
        listItemsMultiChoice(
            R.array.socialNetworks,
            initialSelection = intArrayOf(2, 3),
            disabledIndices = intArrayOf(1, 3)
        ) { _, indices, text ->
          toast("Selected items ${text.joinToString()} at indices ${indices.joinToString()}")
        }
        positiveButton(R.string.choose)
        debugMode(debugMode)
      }
    }

    buttons_stacked.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        message(R.string.useGoogleLocationServicesPrompt)
        positiveButton(text = "Hello World")
        negativeButton(text = "How are you doing?")
        neutralButton(text = "Testing long buttons")
        debugMode(debugMode)
      }
    }

    buttons_stacked_checkboxPrompt.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        message(R.string.useGoogleLocationServicesPrompt)
        positiveButton(text = "Hello World")
        negativeButton(text = "How are you doing?")
        neutralButton(text = "Testing long buttons")
        checkBoxPrompt(R.string.checkboxConfirm) { checked ->
          toast("Checked? $checked")
        }
        debugMode(debugMode)
      }
    }

    buttons_neutral.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        message(R.string.useGoogleLocationServicesPrompt)
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        neutralButton(R.string.more_info)
        debugMode(debugMode)
      }
    }

    buttons_callbacks.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        message(R.string.useGoogleLocationServicesPrompt)
        positiveButton(R.string.agree) { _ ->
          toast("On positive")
        }
        negativeButton(R.string.disagree) { _ ->
          toast("On negative")
        }
        neutralButton(R.string.more_info) { _ ->
          toast("On neutral")
        }
        debugMode(debugMode)
      }
    }

    misc_dialog_callbacks.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        message(R.string.useGoogleLocationServicesPrompt)
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        onShow { _ -> toast("onShow") }
        onCancel { _ -> toast("onCancel") }
        onDismiss { _ -> toast("onDismiss") }
        debugMode(debugMode)
      }
    }

    input.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
          input(
            hint = "Type something",
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
        ) { _, text ->
          toast("Input: $text")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    input_message.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        message(R.string.useGoogleLocationServicesPrompt)
        input(
            hint = "Type something",
            prefill = "Pre-filled!",
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
        ) { _, text ->
          toast("Input: $text")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    input_counter.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        input(
            hint = "Type something",
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS,
            maxLength = 8
        ) { _, text ->
          toast("Input: $text")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        debugMode(debugMode)
      }
    }

    input_check_prompt.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.useGoogleLocationServices)
        input(
            hint = "Type something",
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS
        ) { _, text ->
          toast("Input: $text")
        }
        positiveButton(R.string.agree)
        negativeButton(R.string.disagree)
        checkBoxPrompt(R.string.checkboxConfirm) { checked ->
          toast("Checked? $checked")
        }
        debugMode(debugMode)
      }
    }

    custom_view.setOnClickListener { showCustomViewDialog() }

    custom_view_webview.setOnClickListener { showWebViewDialog() }

    colorChooser_primary.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.primary_colors)
        colorChooser(
            ColorPalette.Primary,
            ColorPalette.PrimarySub
        ) { _, color ->
          toast("Selected color: ${color.toHex()}")
        }
        positiveButton(R.string.select)
        negativeButton(android.R.string.cancel)
        debugMode(debugMode)
      }
    }

    colorChooser_accent.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.accent_colors)
        colorChooser(
            ColorPalette.Accent,
            ColorPalette.AccentSub
        ) { _, color ->
          toast("Selected color: ${color.toHex()}")
        }
        positiveButton(R.string.select)
        negativeButton(android.R.string.cancel)
        debugMode(debugMode)
      }
    }

    colorChooser_customColors.setOnClickListener {
      val topLevel = intArrayOf(Color.TRANSPARENT, Color.RED, Color.YELLOW, Color.BLUE)
      val subLevel = arrayOf(
          intArrayOf(Color.WHITE, Color.TRANSPARENT, Color.BLACK),
          intArrayOf(Color.LTGRAY, Color.GRAY, Color.DKGRAY),
          intArrayOf(Color.GREEN),
          intArrayOf(Color.MAGENTA, Color.CYAN)
      )

      MaterialDialog(this).show {
        title(R.string.custom_colors)
        colorChooser(topLevel, subLevel) { _, color ->
          val colorStr =
            if (color == TRANSPARENT) "transparent"
            else color.toHex()
          toast("Selected color: $colorStr")
        }
        positiveButton(R.string.select)
        negativeButton(android.R.string.cancel)
        debugMode(debugMode)
      }
    }

    colorChooser_customColorsNoSub.setOnClickListener {
      val topLevel = intArrayOf(Color.RED, Color.YELLOW, Color.BLUE)

      MaterialDialog(this).show {
        title(R.string.custom_colors)
        colorChooser(topLevel) { _, color ->
          toast("Selected color: ${color.toHex()}")
        }
        positiveButton(R.string.select)
        negativeButton(android.R.string.cancel)
        debugMode(debugMode)
      }
    }

    colorChooser_primary_customRgb.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.custom_colors_rgb)
        colorChooser(
            colors = ColorPalette.Primary,
            subColors = ColorPalette.PrimarySub,
            allowCustomArgb = true
        ) { _, color ->
          toast("Selected color: ${color.toHex()}")
        }
        positiveButton(R.string.select)
        negativeButton(android.R.string.cancel)
        debugMode(debugMode)
      }
    }

    colorChooser_primary_customArgb.setOnClickListener {
      MaterialDialog(this).show {
        title(R.string.custom_colors_argb)
        colorChooser(
            colors = ColorPalette.Primary,
            subColors = ColorPalette.PrimarySub,
            allowCustomArgb = true,
            showAlphaSelector = true
        ) { _, color ->
          toast("Selected color: ${color.toHex()}")
        }
        positiveButton(R.string.select)
        negativeButton(android.R.string.cancel)
        debugMode(debugMode)
      }
    }

    file_chooser.setOnClickListener { showFileChooser() }

    file_chooser_buttons.setOnClickListener { showFileChooserButtons() }

    file_chooser_filter.setOnClickListener { showFileChooserFilter() }

    folder_chooser_buttons.setOnClickListener { showFolderChooserButtons() }

    folder_chooser_filter.setOnClickListener { showFolderChooserFilter() }
  }

  private fun showCustomViewDialog() {
    val dialog = MaterialDialog(this).show {
      title(R.string.googleWifi)
      customView(R.layout.custom_view, scrollable = true)
      positiveButton(R.string.connect) { dialog ->
        // Pull the password out of the custom view when the positive button is pressed
        val passwordInput: EditText = dialog.getCustomView().findViewById(R.id.password)
        toast("Password: $passwordInput")
      }
      negativeButton(android.R.string.cancel)
      debugMode(debugMode)
    }

    // Setup custom view content
    val customView = dialog.getCustomView()
    val passwordInput: EditText = customView.findViewById(R.id.password)
    val showPasswordCheck: CheckBox = customView.findViewById(R.id.showPassword)
    showPasswordCheck.setOnCheckedChangeListener { _, isChecked ->
      passwordInput.inputType =
          if (!isChecked) InputType.TYPE_TEXT_VARIATION_PASSWORD else InputType.TYPE_CLASS_TEXT
      passwordInput.transformationMethod =
          if (!isChecked) PasswordTransformationMethod.getInstance() else null
    }
  }

  private fun showWebViewDialog() {
    val dialog = MaterialDialog(this).show {
      customView(R.layout.custom_view_webview, noVerticalPadding = true)
      debugMode(debugMode)
    }

    dialog.onShow {
      val webView: WebView = it.getCustomView().findViewById(R.id.web_view)
      webView.loadData(
          "<h3>WebView Custom View</h3>\n" +
              "\n" +
              "<ol>\n" +
              "    <li><b>NEW:</b> Hey!</li>\n" +
              "    <li><b>IMPROVE:</b> Hello!</li>\n" +
              "    <li><b>FIX:</b> Hi!</li>\n" +
              "    <li><b>FIX:</b> Hey again!</li>\n" +
              "    <li><b>FIX:</b> What?</li>\n" +
              "    <li><b>FIX:</b> This is an example.</li>\n" +
              "    <li><b>MISC:</b> How are you?</li>\n" +
              "</ol>\n" +
              "<p>Material guidelines for dialogs:\n" +
              "    <a href='http://www.google.com/design/spec/components/dialogs.html'>" +
              "http://www.google.com/design/spec/components/dialogs.html</a>.\n" +
              "</p>",
          "text/html",
          "UTF-8"
      )
    }
  }

  private fun showFileChooser() = runWithPermissions(READ_EXTERNAL_STORAGE) {
    MaterialDialog(this).show {
      fileChooser { _, file ->
        toast("Selected file: ${file.absolutePath}")
      }
      debugMode(debugMode)
    }
  }

  private fun showFileChooserButtons() = runWithPermissions(WRITE_EXTERNAL_STORAGE) {
    MaterialDialog(this).show {
      fileChooser(allowFolderCreation = true) { _, file ->
        toast("Selected file: ${file.absolutePath}")
      }
      negativeButton(android.R.string.cancel)
      positiveButton(R.string.select)
      debugMode(debugMode)
    }
  }

  private fun showFileChooserFilter() = runWithPermissions(READ_EXTERNAL_STORAGE) {
    MaterialDialog(this).show {
      fileChooser(filter = { it.extension == "txt" }) { _, file ->
        toast("Selected file: ${file.absolutePath}")
      }
      debugMode(debugMode)
    }
  }

  private fun showFolderChooserButtons() = runWithPermissions(WRITE_EXTERNAL_STORAGE) {
    MaterialDialog(this).show {
      folderChooser(allowFolderCreation = true) { _, folder ->
        toast("Selected folder: ${folder.absolutePath}")
      }
      negativeButton(android.R.string.cancel)
      positiveButton(R.string.select)
      debugMode(debugMode)
    }
  }

  private fun showFolderChooserFilter() = runWithPermissions(READ_EXTERNAL_STORAGE) {
    MaterialDialog(this).show {
      folderChooser(filter = { it.name.startsWith("a", true) }) { _, folder ->
        toast("Selected folder: ${folder.absolutePath}")
      }
      debugMode(debugMode)
    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.main, menu)
    val theme = prefs.getString(KEY_THEME, LIGHT)
    if (theme == LIGHT) {
      menu.findItem(R.id.light_theme)
          .isChecked = true
    }
    if (theme == DARK) {
      menu.findItem(R.id.dark_theme)
          .isChecked = true
    }
    if (theme == CUSTOM) {
      menu.findItem(R.id.custom_theme)
          .isChecked = true
    }
    menu.findItem(R.id.debug_mode)
        .isChecked = debugMode
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.light_theme -> {
        prefs.commit {
          putString(KEY_THEME, LIGHT)
        }
        recreate()
        return true
      }
      R.id.dark_theme -> {
        prefs.commit {
          putString(KEY_THEME, DARK)
        }
        recreate()
        return true
      }
      R.id.custom_theme -> {
        prefs.commit {
          putString(KEY_THEME, CUSTOM)
        }
        recreate()
        return true
      }
      R.id.debug_mode -> {
        debugMode = !debugMode
        prefs.commit {
          putBoolean(KEY_DEBUG_MODE, debugMode)
        }
        invalidateOptionsMenu()
        return true
      }
    }
    return super.onOptionsItemSelected(item)
  }
}