package me.rhunk.snapenhance.common.bridge

import me.rhunk.snapenhance.bridge.storage.FileHandleManager

open class InternalFileWrapper(
    fileHandleManager: FileHandleManager,
    private val fileType: InternalFileHandleType,
    val defaultValue: String? = null
): FileHandleWrapper(lazy { fileHandleManager.getFileHandle(FileHandleScope.INTERNAL.key, fileType.key)!! }) {
    override fun readBytes(): ByteArray {
        val bytes = super.readBytes()
        if (bytes.isEmpty()) {
            defaultValue?.let { writeBytes(it.toByteArray()) }
        }
        return super.readBytes()
    }
}