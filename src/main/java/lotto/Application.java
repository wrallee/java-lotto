package lotto;

import lotto.shop.LottoShop;
import lotto.shop.Lottos;

public class Application {

	// TODO 패키지 분리에 대해 고민할 것
	public static void main(String[] args) {
		LottoShop shop = new LottoShop();

		Wallet wallet = InputView.wallet();

		Lottos beforeBuy = InputView.manualLottos(wallet);

		Lottos lottos = shop.buyLottos(wallet, beforeBuy);
		ResultView.printBuyResult(lottos, beforeBuy.count());

		Lotto winningNumber = InputView.winningNumber();
		LottoNumber bonusBall = InputView.bonusBall();

		WinningLotto winningLotto = new WinningLotto(winningNumber, bonusBall);
		GameResult result = new GameResult(winningLotto, lottos);
		ResultView.printWinningResult(result);
	}
}
