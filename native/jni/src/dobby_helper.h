#pragma once

#include <pthread.h>
#include <sys/mman.h>
#include <string.h>
#include <dobby.h>
#include "logger.h"


static pthread_mutex_t hook_mutex = PTHREAD_MUTEX_INITIALIZER;

static void inline SafeHook(void *addr, void *hook, void **original) {
    pthread_mutex_lock(&hook_mutex);
    DobbyHook(addr, hook, original);
    pthread_mutex_unlock(&hook_mutex);
}