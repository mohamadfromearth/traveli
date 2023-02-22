//
// Created by GCO2 on 7/17/22.
//

#include "native-lib.h"
#include <jni.h>
#include <iosfwd>

using namespace std;

extern "C" jstring
Java_main_ApplicationClass_getBaseApi(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("https://traveli2.gcoapps.com/api/");
}
extern "C"
JNIEXPORT jstring JNICALL
Java_main_ApplicationClass_getBaseUrl(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("https://traveli2.gcoapps.com/");
}