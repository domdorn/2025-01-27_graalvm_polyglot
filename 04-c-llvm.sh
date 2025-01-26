#!/bin/bash

# Navigate to the Rust source directory
cd "$(dirname "$0")"

DIR="$(dirname "$0")"

# Ensure wasm-pack is installed
if ! command -v clang &> /dev/null
then
    echo "llvm not found. Installing..."
    brew install llvm
fi

emcc src/main/c/random/get_random_number.c -o src/main/resources/wasm/random/random.wasm \
    -s EXPORTED_FUNCTIONS='["_get_random_number"]' \
    -s STANDALONE_WASM \
    --no-entry