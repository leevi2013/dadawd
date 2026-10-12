private void finishSpin() {
    spinning = false;

    for (int i = 0; i < reels.length; i++) {
        reels[i] = randomSlotItem();
    }

    int winnings = 0;

    // Prüft jede waagerechte Reihe.
    for (int row = 0; row < 3; row++) {
        class_1792 left = reels[row * 3];
        class_1792 middle = reels[row * 3 + 1];
        class_1792 right = reels[row * 3 + 2];

        if (left == middle && middle == right) {
            winnings += threeOfAKindPayout(left);
        } else if (left == middle || left == right || middle == right) {
            winnings += 50;
        }
    }

    if (winnings > 0) {
        GambaClient.addCoins(winnings);
        status = "Gewonnen: +" + winnings + " Münzen!";
        GambaClient.playSound(class_3417.field_14709, 1.1f);
    } else {
        status = "Kein Gewinn – nächstes Mal!";
        GambaClient.playSound(class_3417.field_14823, 0.8f);
    }
}

private int threeOfAKindPayout(class_1792 item) {
    if (item == class_1802.field_22020) return 1000; // Netherit
    if (item == class_1802.field_8477) return 500;   // Diamant
    if (item == class_1802.field_8695) return 250;   // Gold
    if (item == class_1802.field_8620) return 150;   // Eisen
    return 100;                                      // Kupfer
}
