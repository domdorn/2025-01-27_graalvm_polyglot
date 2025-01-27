use rand::prelude::*;
use rand::rngs::SmallRng;
use rand::SeedableRng;

/// Generates a random floating-point number between 0 and 1
#[no_mangle]
pub extern "C" fn get_random_number() -> f64 {
    let mut rng = SmallRng::from_entropy();
    rng.gen::<f64>()
}