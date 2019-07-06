.class public abstract Lcom/laiqian/ui/ActivityRoot;
.super Landroid/support/v7/app/AppCompatActivity;
.source "ActivityRoot.java"


# static fields
.field public static handler:Landroid/os/Handler;

.field private static handlerThread:Landroid/os/HandlerThread;

.field public static shellInteractive:Leu/chainfire/libsuperuser/b$c;


# instance fields
.field inheritableValues:Lcom/laiqian/ui/a$a;

.field localValues:Lcom/laiqian/ui/a$a;

.field protected moneySymbol:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    return-void
.end method

.method private setTitleTextViewRightView(Ljava/lang/CharSequence;Z)Landroid/widget/TextView;
    .locals 1

    .line 241
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_text:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 243
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    if-nez p2, :cond_0

    .line 245
    sget p1, Lcom/laiqian/infrastructure/R$id;->title_right_text:I

    invoke-virtual {p0, p1}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const/16 p2, 0x8

    invoke-virtual {p1, p2}, Landroid/view/View;->setVisibility(I)V

    :cond_0
    return-object v0
.end method


# virtual methods
.method public Callback()V
    .locals 0

    return-void
.end method

.method protected addTitleBottomShadow()V
    .locals 0

    return-void
.end method

.method public beforeCloseActivity()Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public closeActivity(Landroid/view/View;)V
    .locals 0

    .line 423
    invoke-virtual {p0}, Lcom/laiqian/ui/ActivityRoot;->onBackPressed()V

    return-void
.end method

.method protected closeAdapterCursor(Landroid/widget/ListView;)V
    .locals 1

    if-eqz p1, :cond_0

    .line 164
    invoke-virtual {p1}, Landroid/widget/ListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object p1

    if-eqz p1, :cond_0

    .line 166
    instance-of v0, p1, Landroid/widget/CursorAdapter;

    if-eqz v0, :cond_0

    .line 167
    check-cast p1, Landroid/widget/CursorAdapter;

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/CursorAdapter;->changeCursor(Landroid/database/Cursor;)V

    :cond_0
    return-void
.end method

.method protected closeInteractiveShell()V
    .locals 2

    .line 508
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x12

    if-lt v0, v1, :cond_0

    .line 510
    sget-object v0, Lcom/laiqian/ui/ActivityRoot;->handlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->quitSafely()Z

    goto :goto_0

    .line 511
    :cond_0
    sget-object v0, Lcom/laiqian/ui/ActivityRoot;->handlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->quit()Z

    .line 512
    :goto_0
    sget-object v0, Lcom/laiqian/ui/ActivityRoot;->shellInteractive:Leu/chainfire/libsuperuser/b$c;

    invoke-virtual {v0}, Leu/chainfire/libsuperuser/b$c;->close()V

    return-void
.end method

.method public finish()V
    .locals 0

    .line 104
    invoke-static {p0}, Lcom/laiqian/util/n;->R(Landroid/app/Activity;)V

    .line 105
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->finish()V

    return-void
.end method

.method public getActivity()Lcom/laiqian/ui/ActivityRoot;
    .locals 0

    return-object p0
.end method

.method public getContentView()Landroid/view/View;
    .locals 2

    const v0, 0x1020002

    .line 462
    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    const/4 v1, 0x0

    .line 463
    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getFinishStatus(Landroid/app/Activity;)Z
    .locals 3

    .line 474
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x0

    const/16 v2, 0x11

    if-lt v0, v2, :cond_0

    .line 475
    invoke-virtual {p1}, Landroid/app/Activity;->isDestroyed()Z

    move-result v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    if-nez v0, :cond_2

    .line 477
    invoke-virtual {p1}, Landroid/app/Activity;->isFinishing()Z

    move-result p1

    if-eqz p1, :cond_1

    goto :goto_1

    :cond_1
    return v1

    :cond_2
    :goto_1
    const/4 p1, 0x1

    return p1
.end method

.method public getLaiqianPreferenceManager()Lcom/laiqian/util/av;
    .locals 1

    .line 155
    invoke-static {}, Lcom/laiqian/basic/RootApplication;->getLaiqianPreferenceManager()Lcom/laiqian/util/av;

    move-result-object v0

    return-object v0
.end method

.method protected getTitleCenterCustomize()Landroid/view/ViewGroup;
    .locals 1

    .line 271
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_center_customize:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    return-object v0
.end method

.method protected getTitleRightCustomize()Landroid/view/ViewGroup;
    .locals 1

    .line 264
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_customize:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    return-object v0
.end method

.method public getTitleTextView()Ljava/lang/String;
    .locals 1

    .line 255
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_text:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected initializeInteractiveShell()V
    .locals 2

    .line 496
    new-instance v0, Landroid/os/HandlerThread;

    const-string v1, "handler"

    invoke-direct {v0, v1}, Landroid/os/HandlerThread;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/laiqian/ui/ActivityRoot;->handlerThread:Landroid/os/HandlerThread;

    .line 497
    sget-object v0, Lcom/laiqian/ui/ActivityRoot;->handlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v0}, Landroid/os/HandlerThread;->start()V

    .line 498
    new-instance v0, Landroid/os/Handler;

    sget-object v1, Lcom/laiqian/ui/ActivityRoot;->handlerThread:Landroid/os/HandlerThread;

    invoke-virtual {v1}, Landroid/os/HandlerThread;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v0, Lcom/laiqian/ui/ActivityRoot;->handler:Landroid/os/Handler;

    .line 499
    new-instance v0, Leu/chainfire/libsuperuser/b$a;

    invoke-direct {v0}, Leu/chainfire/libsuperuser/b$a;-><init>()V

    invoke-virtual {v0}, Leu/chainfire/libsuperuser/b$a;->aBf()Leu/chainfire/libsuperuser/b$a;

    move-result-object v0

    sget-object v1, Lcom/laiqian/ui/ActivityRoot;->handler:Landroid/os/Handler;

    invoke-virtual {v0, v1}, Leu/chainfire/libsuperuser/b$a;->g(Landroid/os/Handler;)Leu/chainfire/libsuperuser/b$a;

    move-result-object v0

    invoke-virtual {v0}, Leu/chainfire/libsuperuser/b$a;->aBg()Leu/chainfire/libsuperuser/b$c;

    move-result-object v0

    sput-object v0, Lcom/laiqian/ui/ActivityRoot;->shellInteractive:Leu/chainfire/libsuperuser/b$c;

    return-void
.end method

.method final synthetic lambda$onBackPressed$0$ActivityRoot(Ljava/lang/IllegalStateException;)V
    .locals 3

    const-string v0, "Can not perform this action after onSaveInstanceState"

    .line 437
    invoke-virtual {p1}, Ljava/lang/IllegalStateException;->getMessage()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result p1

    if-eqz p1, :cond_0

    const/4 p1, 0x1

    .line 439
    new-array p1, p1, [Ljava/lang/String;

    const/4 v0, 0x0

    const-string v1, "report@androidcloudpos.cn"

    aput-object v1, p1, v0

    const-string v0, "Can not perform this action after onSaveInstanceState \u5f02\u5e38"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\u7248\u672c"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 440
    invoke-static {}, Lcom/laiqian/basic/LQKVersion;->zq()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "\u51fa\u73b0"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "Activity \u662f\u5426 Finishing\uff1a "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/laiqian/ui/ActivityRoot;->isFinishing()Z

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    .line 439
    invoke-static {p1, v0, v1, v2}, Lcom/laiqian/util/n;->a([Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z

    :cond_0
    return-void
.end method

.method public onBackPressed()V
    .locals 3

    .line 430
    :try_start_0
    invoke-virtual {p0}, Lcom/laiqian/ui/ActivityRoot;->beforeCloseActivity()Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 433
    :cond_0
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onBackPressed()V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    .line 436
    invoke-static {}, Lio/reactivex/g/a;->aKh()Lio/reactivex/m;

    move-result-object v1

    new-instance v2, Lcom/laiqian/ui/b;

    invoke-direct {v2, p0, v0}, Lcom/laiqian/ui/b;-><init>(Lcom/laiqian/ui/ActivityRoot;Ljava/lang/IllegalStateException;)V

    invoke-virtual {v1, v2}, Lio/reactivex/m;->r(Ljava/lang/Runnable;)Lio/reactivex/a/b;

    :goto_0
    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0

    .line 62
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 63
    invoke-static {p0, p1}, Lcom/laiqian/ui/a/i;->a(Landroid/content/Context;Landroid/content/res/Configuration;)V

    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0

    .line 53
    invoke-virtual {p0}, Lcom/laiqian/ui/ActivityRoot;->setRequestedOrientation()V

    .line 54
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 55
    invoke-static {p0}, Lcom/laiqian/util/n;->aL(Landroid/content/Context;)V

    .line 56
    invoke-static {}, Lcom/laiqian/basic/RootApplication;->zA()Ljava/lang/String;

    move-result-object p1

    iput-object p1, p0, Lcom/laiqian/ui/ActivityRoot;->moneySymbol:Ljava/lang/String;

    .line 57
    sget-object p1, Lcom/laiqian/basic/RootApplication;->aIV:Ljava/util/ArrayList;

    invoke-virtual {p1, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method protected onDestroy()V
    .locals 2

    .line 110
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onDestroy()V

    .line 111
    invoke-virtual {p0}, Lcom/laiqian/ui/ActivityRoot;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 112
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, "\u8be5\u9875\u9762\u65e0\u6545\u88ab\u9500\u6bc1\u4e86\u4e00\u6b21"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/laiqian/util/n;->println(Ljava/lang/Object;)V

    :cond_0
    return-void
.end method

.method protected performClick(Landroid/view/View;)V
    .locals 0

    .line 180
    invoke-static {p1}, Lcom/laiqian/util/n;->performClick(Landroid/view/View;)V

    return-void
.end method

.method protected resetRefreshButtonProgress()V
    .locals 2

    .line 350
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_refresh_text:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    if-eqz v0, :cond_0

    const/4 v1, 0x0

    .line 352
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 354
    :cond_0
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_refresh_text_progress:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/laiqian/ui/ProgressBarCircularIndeterminate;

    if-eqz v0, :cond_1

    const/4 v1, 0x4

    .line 356
    invoke-virtual {v0, v1}, Lcom/laiqian/ui/ProgressBarCircularIndeterminate;->setVisibility(I)V

    :cond_1
    return-void
.end method

.method protected resetSaveButtonProgress()V
    .locals 2

    .line 309
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_text:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    if-eqz v0, :cond_0

    const/4 v1, 0x0

    .line 311
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 313
    :cond_0
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_text_progress:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/laiqian/ui/ProgressBarCircularIndeterminate;

    if-eqz v0, :cond_1

    const/4 v1, 0x4

    .line 315
    invoke-virtual {v0, v1}, Lcom/laiqian/ui/ProgressBarCircularIndeterminate;->setVisibility(I)V

    :cond_1
    return-void
.end method

.method protected resetSettingButtonProgress()V
    .locals 2

    .line 397
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_setting_text:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    if-eqz v0, :cond_0

    const/4 v1, 0x0

    .line 399
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 401
    :cond_0
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_setting_text_progress:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/laiqian/ui/ProgressBarCircularIndeterminate;

    if-eqz v0, :cond_1

    const/4 v1, 0x4

    .line 403
    invoke-virtual {v0, v1}, Lcom/laiqian/ui/ProgressBarCircularIndeterminate;->setVisibility(I)V

    :cond_1
    return-void
.end method

.method protected setContentViewSetCustomTitle(I)V
    .locals 2
    .param p1    # I
        .annotation build Landroid/support/annotation/LayoutRes;
        .end annotation
    .end param

    const/4 v0, 0x7

    .line 199
    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->requestWindowFeature(I)Z

    .line 200
    invoke-virtual {p0, p1}, Lcom/laiqian/ui/ActivityRoot;->setContentView(I)V

    .line 201
    invoke-virtual {p0}, Lcom/laiqian/ui/ActivityRoot;->getWindow()Landroid/view/Window;

    move-result-object p1

    sget v1, Lcom/laiqian/infrastructure/R$layout;->pos_title:I

    invoke-virtual {p1, v0, v1}, Landroid/view/Window;->setFeatureInt(II)V

    return-void
.end method

.method protected setContentViewSetNoTitle(I)V
    .locals 1
    .param p1    # I
        .annotation build Landroid/support/annotation/LayoutRes;
        .end annotation
    .end param

    const/4 v0, 0x1

    .line 189
    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->requestWindowFeature(I)Z

    .line 190
    invoke-virtual {p0, p1}, Lcom/laiqian/ui/ActivityRoot;->setContentView(I)V

    return-void
.end method

.method protected setRefreshTitleTextViewRight(ILandroid/view/View$OnClickListener;)Landroid/widget/TextView;
    .locals 0
    .param p1    # I
        .annotation build Landroid/support/annotation/StringRes;
        .end annotation
    .end param

    .line 292
    invoke-virtual {p0, p1}, Lcom/laiqian/ui/ActivityRoot;->getText(I)Ljava/lang/CharSequence;

    move-result-object p1

    invoke-virtual {p0, p1, p2}, Lcom/laiqian/ui/ActivityRoot;->setTitleTextRefreshViewRight(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/TextView;

    move-result-object p1

    return-object p1
.end method

.method public setRequestedOrientation()V
    .locals 4

    .line 71
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    .line 72
    invoke-static {}, Lcom/laiqian/basic/RootApplication;->getLaiqianPreferenceManager()Lcom/laiqian/util/av;

    move-result-object v1

    invoke-virtual {v1}, Lcom/laiqian/util/av;->avL()I

    move-result v1

    const/16 v2, 0x9

    const/4 v3, 0x2

    if-ne v1, v3, :cond_1

    if-lt v0, v2, :cond_0

    const/4 v0, 0x7

    .line 74
    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->setRequestedOrientation(I)V

    goto :goto_0

    :cond_0
    const/4 v0, 0x1

    .line 76
    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->setRequestedOrientation(I)V

    goto :goto_0

    :cond_1
    if-lt v0, v2, :cond_2

    const/4 v0, 0x6

    .line 80
    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->setRequestedOrientation(I)V

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    .line 82
    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->setRequestedOrientation(I)V

    :goto_0
    return-void
.end method

.method protected setTitleTextRefreshViewRight(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/TextView;
    .locals 2

    .line 343
    sget v0, Lcom/laiqian/infrastructure/R$id;->fl_refresh:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 344
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_refresh_text:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 345
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 346
    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-object v0
.end method

.method protected setTitleTextView(I)Landroid/widget/TextView;
    .locals 0
    .param p1    # I
        .annotation build Landroid/support/annotation/StringRes;
        .end annotation
    .end param

    .line 228
    invoke-virtual {p0, p1}, Lcom/laiqian/ui/ActivityRoot;->getText(I)Ljava/lang/CharSequence;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/laiqian/ui/ActivityRoot;->setTitleTextView(Ljava/lang/CharSequence;)Landroid/widget/TextView;

    move-result-object p1

    return-object p1
.end method

.method protected setTitleTextView(Ljava/lang/CharSequence;)Landroid/widget/TextView;
    .locals 1

    const/4 v0, 0x1

    .line 237
    invoke-direct {p0, p1, v0}, Lcom/laiqian/ui/ActivityRoot;->setTitleTextViewRightView(Ljava/lang/CharSequence;Z)Landroid/widget/TextView;

    move-result-object p1

    return-object p1
.end method

.method protected setTitleTextViewHideRightView(I)V
    .locals 0
    .param p1    # I
        .annotation build Landroid/support/annotation/StringRes;
        .end annotation
    .end param

    .line 210
    invoke-virtual {p0, p1}, Lcom/laiqian/ui/ActivityRoot;->getText(I)Ljava/lang/CharSequence;

    move-result-object p1

    invoke-virtual {p0, p1}, Lcom/laiqian/ui/ActivityRoot;->setTitleTextViewHideRightView(Ljava/lang/CharSequence;)V

    return-void
.end method

.method protected setTitleTextViewHideRightView(Ljava/lang/CharSequence;)V
    .locals 1

    const/4 v0, 0x0

    .line 219
    invoke-direct {p0, p1, v0}, Lcom/laiqian/ui/ActivityRoot;->setTitleTextViewRightView(Ljava/lang/CharSequence;Z)Landroid/widget/TextView;

    return-void
.end method

.method protected setTitleTextViewRight(ILandroid/view/View$OnClickListener;)Landroid/widget/TextView;
    .locals 0
    .param p1    # I
        .annotation build Landroid/support/annotation/StringRes;
        .end annotation
    .end param

    .line 282
    invoke-virtual {p0, p1}, Lcom/laiqian/ui/ActivityRoot;->getText(I)Ljava/lang/CharSequence;

    move-result-object p1

    invoke-virtual {p0, p1, p2}, Lcom/laiqian/ui/ActivityRoot;->setTitleTextViewRight(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/TextView;

    move-result-object p1

    return-object p1
.end method

.method protected setTitleTextViewRight(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)Landroid/widget/TextView;
    .locals 1

    .line 302
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_text:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 303
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 304
    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-object v0
.end method

.method protected setTitleTextViewRight(Ljava/lang/CharSequence;ZLandroid/view/View$OnClickListener;)Landroid/widget/TextView;
    .locals 7

    .line 319
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_text:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 320
    sget v1, Lcom/laiqian/infrastructure/R$id;->title_right_text_progress:I

    invoke-virtual {p0, v1}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object v4, v1

    check-cast v4, Lcom/laiqian/ui/ProgressBarCircularIndeterminate;

    .line 322
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 323
    new-instance p1, Lcom/laiqian/ui/c;

    move-object v1, p1

    move-object v2, p0

    move v3, p2

    move-object v5, v0

    move-object v6, p3

    invoke-direct/range {v1 .. v6}, Lcom/laiqian/ui/c;-><init>(Lcom/laiqian/ui/ActivityRoot;ZLcom/laiqian/ui/ProgressBarCircularIndeterminate;Landroid/widget/TextView;Landroid/view/View$OnClickListener;)V

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-object v0
.end method

.method protected setTitleTextViewRightRefresh(Ljava/lang/CharSequence;ZLandroid/view/View$OnClickListener;)Landroid/widget/TextView;
    .locals 7

    .line 361
    sget v0, Lcom/laiqian/infrastructure/R$id;->fl_refresh:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 362
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_refresh_text:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 363
    sget v1, Lcom/laiqian/infrastructure/R$id;->title_right_refresh_text_progress:I

    invoke-virtual {p0, v1}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object v4, v1

    check-cast v4, Lcom/laiqian/ui/ProgressBarCircularIndeterminate;

    .line 365
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 366
    new-instance p1, Lcom/laiqian/ui/d;

    move-object v1, p1

    move-object v2, p0

    move v3, p2

    move-object v5, v0

    move-object v6, p3

    invoke-direct/range {v1 .. v6}, Lcom/laiqian/ui/d;-><init>(Lcom/laiqian/ui/ActivityRoot;ZLcom/laiqian/ui/ProgressBarCircularIndeterminate;Landroid/widget/TextView;Landroid/view/View$OnClickListener;)V

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-object v0
.end method

.method protected setTitleTextViewRightSetting(Ljava/lang/CharSequence;ZLandroid/view/View$OnClickListener;)Landroid/widget/TextView;
    .locals 7

    .line 379
    sget v0, Lcom/laiqian/infrastructure/R$id;->fl_setting:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 380
    sget v0, Lcom/laiqian/infrastructure/R$id;->title_right_setting_text:I

    invoke-virtual {p0, v0}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 381
    sget v1, Lcom/laiqian/infrastructure/R$id;->title_right_setting_text_progress:I

    invoke-virtual {p0, v1}, Lcom/laiqian/ui/ActivityRoot;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object v4, v1

    check-cast v4, Lcom/laiqian/ui/ProgressBarCircularIndeterminate;

    .line 383
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 384
    new-instance p1, Lcom/laiqian/ui/e;

    move-object v1, p1

    move-object v2, p0

    move v3, p2

    move-object v5, v0

    move-object v6, p3

    invoke-direct/range {v1 .. v6}, Lcom/laiqian/ui/e;-><init>(Lcom/laiqian/ui/ActivityRoot;ZLcom/laiqian/ui/ProgressBarCircularIndeterminate;Landroid/widget/TextView;Landroid/view/View$OnClickListener;)V

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-object v0
.end method
