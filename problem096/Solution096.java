package problem096;

public class Solution096 {

	public static void main(String[] args) {

		String[] input = s.split("\n");

		for (int i = 0; i < input.length / 10; i++) {
			String[] temp = new String[9];

			for (int j = 0; j < 9; j++) {
				temp[j] = input[10 * i + j + 1];
			}
			new Sudoku(input[10 * i], temp);
		}
		System.out.println(Sudoku.sum);
	}

	static final String s = "Grid 01\n" + "003020600\n" + "900305001\n"
			+ "001806400\n" + "008102900\n" + "700000008\n" + "006708200\n"
			+ "002609500\n" + "800203009\n" + "005010300\n" + "Grid 02\n"
			+ "200080300\n" + "060070084\n" + "030500209\n" + "000105408\n"
			+ "000000000\n" + "402706000\n" + "301007040\n" + "720040060\n"
			+ "004010003\n" + "Grid 03\n" + "000000907\n" + "000420180\n"
			+ "000705026\n" + "100904000\n" + "050000040\n" + "000507009\n"
			+ "920108000\n" + "034059000\n" + "507000000\n" + "Grid 04\n"
			+ "030050040\n" + "008010500\n" + "460000012\n" + "070502080\n"
			+ "000603000\n" + "040109030\n" + "250000098\n" + "001020600\n"
			+ "080060020\n" + "Grid 05\n" + "020810740\n" + "700003100\n"
			+ "090002805\n" + "009040087\n" + "400208003\n" + "160030200\n"
			+ "302700060\n" + "005600008\n" + "076051090\n" + "Grid 06\n"
			+ "100920000\n" + "524010000\n" + "000000070\n" + "050008102\n"
			+ "000000000\n" + "402700090\n" + "060000000\n" + "000030945\n"
			+ "000071006\n" + "Grid 07\n" + "043080250\n" + "600000000\n"
			+ "000001094\n" + "900004070\n" + "000608000\n" + "010200003\n"
			+ "820500000\n" + "000000005\n" + "034090710\n" + "Grid 08\n"
			+ "480006902\n" + "002008001\n" + "900370060\n" + "840010200\n"
			+ "003704100\n" + "001060049\n" + "020085007\n" + "700900600\n"
			+ "609200018\n" + "Grid 09\n" + "000900002\n" + "050123400\n"
			+ "030000160\n" + "908000000\n" + "070000090\n" + "000000205\n"
			+ "091000050\n" + "007439020\n" + "400007000\n" + "Grid 10\n"
			+ "001900003\n" + "900700160\n" + "030005007\n" + "050000009\n"
			+ "004302600\n" + "200000070\n" + "600100030\n" + "042007006\n"
			+ "500006800\n" + "Grid 11\n" + "000125400\n" + "008400000\n"
			+ "420800000\n" + "030000095\n" + "060902010\n" + "510000060\n"
			+ "000003049\n" + "000007200\n" + "001298000\n" + "Grid 12\n"
			+ "062340750\n" + "100005600\n" + "570000040\n" + "000094800\n"
			+ "400000006\n" + "005830000\n" + "030000091\n" + "006400007\n"
			+ "059083260\n" + "Grid 13\n" + "300000000\n" + "005009000\n"
			+ "200504000\n" + "020000700\n" + "160000058\n" + "704310600\n"
			+ "000890100\n" + "000067080\n" + "000005437\n" + "Grid 14\n"
			+ "630000000\n" + "000500008\n" + "005674000\n" + "000020000\n"
			+ "003401020\n" + "000000345\n" + "000007004\n" + "080300902\n"
			+ "947100080\n" + "Grid 15\n" + "000020040\n" + "008035000\n"
			+ "000070602\n" + "031046970\n" + "200000000\n" + "000501203\n"
			+ "049000730\n" + "000000010\n" + "800004000\n" + "Grid 16\n"
			+ "361025900\n" + "080960010\n" + "400000057\n" + "008000471\n"
			+ "000603000\n" + "259000800\n" + "740000005\n" + "020018060\n"
			+ "005470329\n" + "Grid 17\n" + "050807020\n" + "600010090\n"
			+ "702540006\n" + "070020301\n" + "504000908\n" + "103080070\n"
			+ "900076205\n" + "060090003\n" + "080103040\n" + "Grid 18\n"
			+ "080005000\n" + "000003457\n" + "000070809\n" + "060400903\n"
			+ "007010500\n" + "408007020\n" + "901020000\n" + "842300000\n"
			+ "000100080\n" + "Grid 19\n" + "003502900\n" + "000040000\n"
			+ "106000305\n" + "900251008\n" + "070408030\n" + "800763001\n"
			+ "308000104\n" + "000020000\n" + "005104800\n" + "Grid 20\n"
			+ "000000000\n" + "009805100\n" + "051907420\n" + "290401065\n"
			+ "000000000\n" + "140508093\n" + "026709580\n" + "005103600\n"
			+ "000000000\n" + "Grid 21\n" + "020030090\n" + "000907000\n"
			+ "900208005\n" + "004806500\n" + "607000208\n" + "003102900\n"
			+ "800605007\n" + "000309000\n" + "030020050\n" + "Grid 22\n"
			+ "005000006\n" + "070009020\n" + "000500107\n" + "804150000\n"
			+ "000803000\n" + "000092805\n" + "907006000\n" + "030400010\n"
			+ "200000600\n" + "Grid 23\n" + "040000050\n" + "001943600\n"
			+ "009000300\n" + "600050002\n" + "103000506\n" + "800020007\n"
			+ "005000200\n" + "002436700\n" + "030000040\n" + "Grid 24\n"
			+ "004000000\n" + "000030002\n" + "390700080\n" + "400009001\n"
			+ "209801307\n" + "600200008\n" + "010008053\n" + "900040000\n"
			+ "000000800\n" + "Grid 25\n" + "360020089\n" + "000361000\n"
			+ "000000000\n" + "803000602\n" + "400603007\n" + "607000108\n"
			+ "000000000\n" + "000418000\n" + "970030014\n" + "Grid 26\n"
			+ "500400060\n" + "009000800\n" + "640020000\n" + "000001008\n"
			+ "208000501\n" + "700500000\n" + "000090084\n" + "003000600\n"
			+ "060003002\n" + "Grid 27\n" + "007256400\n" + "400000005\n"
			+ "010030060\n" + "000508000\n" + "008060200\n" + "000107000\n"
			+ "030070090\n" + "200000004\n" + "006312700\n" + "Grid 28\n"
			+ "000000000\n" + "079050180\n" + "800000007\n" + "007306800\n"
			+ "450708096\n" + "003502700\n" + "700000005\n" + "016030420\n"
			+ "000000000\n" + "Grid 29\n" + "030000080\n" + "009000500\n"
			+ "007509200\n" + "700105008\n" + "020090030\n" + "900402001\n"
			+ "004207100\n" + "002000800\n" + "070000090\n" + "Grid 30\n"
			+ "200170603\n" + "050000100\n" + "000006079\n" + "000040700\n"
			+ "000801000\n" + "009050000\n" + "310400000\n" + "005000060\n"
			+ "906037002\n" + "Grid 31\n" + "000000080\n" + "800701040\n"
			+ "040020030\n" + "374000900\n" + "000030000\n" + "005000321\n"
			+ "010060050\n" + "050802006\n" + "080000000\n" + "Grid 32\n"
			+ "000000085\n" + "000210009\n" + "960080100\n" + "500800016\n"
			+ "000000000\n" + "890006007\n" + "009070052\n" + "300054000\n"
			+ "480000000\n" + "Grid 33\n" + "608070502\n" + "050608070\n"
			+ "002000300\n" + "500090006\n" + "040302050\n" + "800050003\n"
			+ "005000200\n" + "010704090\n" + "409060701\n" + "Grid 34\n"
			+ "050010040\n" + "107000602\n" + "000905000\n" + "208030501\n"
			+ "040070020\n" + "901080406\n" + "000401000\n" + "304000709\n"
			+ "020060010\n" + "Grid 35\n" + "053000790\n" + "009753400\n"
			+ "100000002\n" + "090080010\n" + "000907000\n" + "080030070\n"
			+ "500000003\n" + "007641200\n" + "061000940\n" + "Grid 36\n"
			+ "006080300\n" + "049070250\n" + "000405000\n" + "600317004\n"
			+ "007000800\n" + "100826009\n" + "000702000\n" + "075040190\n"
			+ "003090600\n" + "Grid 37\n" + "005080700\n" + "700204005\n"
			+ "320000084\n" + "060105040\n" + "008000500\n" + "070803010\n"
			+ "450000091\n" + "600508007\n" + "003010600\n" + "Grid 38\n"
			+ "000900800\n" + "128006400\n" + "070800060\n" + "800430007\n"
			+ "500000009\n" + "600079008\n" + "090004010\n" + "003600284\n"
			+ "001007000\n" + "Grid 39\n" + "000080000\n" + "270000054\n"
			+ "095000810\n" + "009806400\n" + "020403060\n" + "006905100\n"
			+ "017000620\n" + "460000038\n" + "000090000\n" + "Grid 40\n"
			+ "000602000\n" + "400050001\n" + "085010620\n" + "038206710\n"
			+ "000000000\n" + "019407350\n" + "026040530\n" + "900020007\n"
			+ "000809000\n" + "Grid 41\n" + "000900002\n" + "050123400\n"
			+ "030000160\n" + "908000000\n" + "070000090\n" + "000000205\n"
			+ "091000050\n" + "007439020\n" + "400007000\n" + "Grid 42\n"
			+ "380000000\n" + "000400785\n" + "009020300\n" + "060090000\n"
			+ "800302009\n" + "000040070\n" + "001070500\n" + "495006000\n"
			+ "000000092\n" + "Grid 43\n" + "000158000\n" + "002060800\n"
			+ "030000040\n" + "027030510\n" + "000000000\n" + "046080790\n"
			+ "050000080\n" + "004070100\n" + "000325000\n" + "Grid 44\n"
			+ "010500200\n" + "900001000\n" + "002008030\n" + "500030007\n"
			+ "008000500\n" + "600080004\n" + "040100700\n" + "000700006\n"
			+ "003004050\n" + "Grid 45\n" + "080000040\n" + "000469000\n"
			+ "400000007\n" + "005904600\n" + "070608030\n" + "008502100\n"
			+ "900000005\n" + "000781000\n" + "060000010\n" + "Grid 46\n"
			+ "904200007\n" + "010000000\n" + "000706500\n" + "000800090\n"
			+ "020904060\n" + "040002000\n" + "001607000\n" + "000000030\n"
			+ "300005702\n" + "Grid 47\n" + "000700800\n" + "006000031\n"
			+ "040002000\n" + "024070000\n" + "010030080\n" + "000060290\n"
			+ "000800070\n" + "860000500\n" + "002006000\n" + "Grid 48\n"
			+ "001007090\n" + "590080001\n" + "030000080\n" + "000005800\n"
			+ "050060020\n" + "004100000\n" + "080000030\n" + "100020079\n"
			+ "020700400\n" + "Grid 49\n" + "000003017\n" + "015009008\n"
			+ "060000000\n" + "100007000\n" + "009000200\n" + "000500004\n"
			+ "000000020\n" + "500600340\n" + "340200000\n" + "Grid 50\n"
			+ "300200000\n" + "000107000\n" + "706030500\n" + "070009080\n"
			+ "900020004\n" + "010800050\n" + "009040301\n" + "000702000\n"
			+ "000008006";
}
