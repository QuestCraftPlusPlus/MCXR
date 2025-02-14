/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.openxr;

import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NativeType;

import static org.lwjgl.system.Checks.CHECKS;
import static org.lwjgl.system.Checks.check;
import static org.lwjgl.system.JNI.callPI;

/** The KHR_loader_init extension. */
public class KHRLoaderInit {

    /** The extension specification version. */
    public static final int XR_KHR_loader_init_SPEC_VERSION = 1;

    /** The extension name. */
    public static final String XR_KHR_LOADER_INIT_EXTENSION_NAME = "XR_KHR_loader_init";

    protected KHRLoaderInit() {
        throw new UnsupportedOperationException();
    }

    // --- [ xrInitializeLoaderKHR ] ---

    public static int nxrInitializeLoaderKHR(long loaderInitInfo) {
        long __functionAddress = XR.getGlobalCommands().xrInitializeLoaderKHR;
        if (CHECKS) {
            check(__functionAddress);
        }
        return callPI(loaderInitInfo, __functionAddress);
    }

    @NativeType("XrResult")
    public static int xrInitializeLoaderKHR(@NativeType("XrLoaderInitInfoBaseHeaderKHR const *") XrLoaderInitInfoBaseHeaderKHR loaderInitInfo) {
        return nxrInitializeLoaderKHR(loaderInitInfo.address());
    }

}