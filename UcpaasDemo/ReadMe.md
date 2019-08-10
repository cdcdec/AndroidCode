
IMMessageActivity
CustomLog.v("开启拨打视频电话。。。");
1016

LoginHandler

72行：RestTools.LOGIN_REST_TOKEN_OK

UCSManager.connect(token, this);




IMLoginV2Activity登录

com.yzx.im_demo.
IMDemoActivity,跳转到--》IMLoginV2Activity,--->

RestTools.loginByToken("smt0169",mHandler,"eyJBbGciOiJIUzI1NiIsIkFjY2lkIjoiMWM2NGE2MzMwZTRhNDRlMWI4ODQwN2UzYmM5OGRmNDEiLCJBcHBpZCI6IjgxNTBiMDQ4ZWQ3OTRmM2U4NzQzOWViZmMxY2I2N2QwIiwiVXNlcmlkIjoiMTEwMDA3MzYifQ==.JmDnMo8vZtbPhEN1zjIf18ctVMVYRl/PL2ihEc400dA=");


--->IMLoginV2Activity,接收handler消息-->LoginHandler,在startLoginTimer中发送消息
sendEmptyMessage(RestTools.LOGIN_STATUS_TIMEOUT);

---》




