#include <stdlib.h>
#include <time.h>
#include <emscripten.h>

// Ensure function is accessible from JavaScript/Java
EMSCRIPTEN_KEEPALIVE
double get_random_number() {
    srand(time(NULL)); // Seed randomness
    return (double)rand() / RAND_MAX;
}