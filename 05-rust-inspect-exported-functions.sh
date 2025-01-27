#!/bin/bash

# Navigate to the Rust source directory
cd "$(dirname "$0")"

DIR="$(dirname "$0")"

# Ensure wasm-pack is installed
if ! command -v wasm-tools &> /dev/null
then
    echo "wasm-tools not found. Installing..."
    cargo install wasm-tools
fi

echo "DIR is $DIR"

cd $DIR/src/main/rust/random

wasm-tools component ../../resources/wasm/random/rust_wasm_random_bg.wasm