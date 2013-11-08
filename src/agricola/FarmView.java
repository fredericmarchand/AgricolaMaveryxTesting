package agricola;

//Author: Robert Souter 100802267
//Supervisor: Jean-Pierre Corriveau Ph.D.
//Carleton University
//School of Computer Science
//COMP 4905
//Winter 2013

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class FarmView extends JFrame {

	private FarmPanel panel_farm;
	private JButton[] buttons;
	private JButton[] buttons3;
	private JButton[] buttons4;
	private JButton[] buttons5;
	private JMenuBar menu;
	private JMenu gmenu;
	private ButtonGroup playergroup;
	private JRadioButtonMenuItem player1, player2, player3, player4, player5;

	private Label r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14,
			l_totalI, l_totalPI;
	private Label label_food, label_reed, label_wood, label_clay, label_stone,
			label_grain, label_vege, l_harvest1, l_harvest2, l_harvest3,
			l_harvest4, l_harvest5, l_harvest6, l_tfam, l_fam, l_turn, l_cur,
			l_star, l_sheep, l_boar, l_cattle, l_pasture, l_viewer;
	private JTextField text_food, text_reed, text_wood, text_clay, text_stone,
			text_grain, text_vege, text_turn, t_cur, t_star, p_sheep, p_cattle,
			p_boar;
	private JTextField t_wood, t_clay, t_reed, t_food, t_sheep, t_stone,
			t_boar, t_cattle, t_stone2, t_tfam, t_fam, t_viewer;
	private JTextField t3_wood, t3_clay, t4_wood, t4_2wood, t4_clay, t4_food,
			t5_reed, t5_food, t5_clay, t5_wood, p_pasture;
	@SuppressWarnings("unused")
	private JButton b_room, b_start, b_grain, b_field, b_stable, b_day,
			b_3wood, b_clay, b_reed, b_food, b_improve, b_sow, b_fences,
			b_sheep, b_renov, b_growth, b_stone, b_boar, b_vege, b_stone2,
			b_cattle, b_fieldsow, b_growth2, b_renov2, b_finishaction;
	private Label l_fireplace, l_fireplace2, l_hearth, l_hearth2, l_coven,
			l_soven, l_joinery, l_pottery, l_basket, l_well, l2_fireplace,
			l2_fireplace2, l2_hearth, l2_hearth2, l2_coven, l2_soven,
			l2_joinery, l2_pottery, l2_basket, l2_well;

	public JTextField getSpaceTypes;

	public FarmView() {
		super("Agricola");
		setLayout(null);
		setSize(1110, 650);
		buttons = new JButton[25];
		buttons3 = new JButton[4];
		buttons4 = new JButton[6];
		buttons5 = new JButton[6];
		l_turn = new Label("Round:");
		l_turn.setSize(43, 18);
		l_turn.setLocation(10, 70);
		add(l_turn);

		text_turn = new JTextField("1");
		text_turn.setToolTipText("gameTurn");
		text_turn.setEditable(false);
		text_turn.setSize(24, 18);
		text_turn.setLocation(57, 70);
		text_turn.setBackground(Color.white);
		add(text_turn);

		l_cur = new Label("Current Player:");
		l_cur.setSize(84, 18);
		l_cur.setLocation(105, 70);
		add(l_cur);

		t_cur = new JTextField("1");
		t_cur.setToolTipText("curPlayer");
		t_cur.setEditable(false);
		t_cur.setSize(24, 18);
		t_cur.setLocation(195, 70);
		t_cur.setBackground(Color.white);
		add(t_cur);

		l_star = new Label("Start Player:");
		l_star.setSize(71, 18);
		l_star.setLocation(252, 70);
		add(l_star);

		t_star = new JTextField("1");
		t_star.setEditable(false);
		t_star.setSize(24, 18);
		t_star.setLocation(323, 70);
		t_star.setBackground(Color.white);
		add(t_star);

		l_viewer = new Label("Viewing Player:");
		l_viewer.setSize(85, 18);
		l_viewer.setLocation(377, 70);
		add(l_viewer);

		t_viewer = new JTextField("1");
		t_viewer.setEditable(false);
		t_viewer.setSize(24, 18);
		t_viewer.setLocation(472, 70);
		t_viewer.setBackground(Color.white);
		add(t_viewer);

		l_totalI = new Label("Available Improvements");
		l_totalI.setSize(190, 18);
		l_totalI.setLocation(54, 505);
		l_totalI.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		add(l_totalI);

		l_totalPI = new Label("Viewing Player Improvements");
		l_totalPI.setSize(250, 18);
		l_totalPI.setLocation(356, 505);
		l_totalPI.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		add(l_totalPI);

		l_fireplace = new Label("Fireplace");
		l_fireplace.setSize(55, 18);
		l_fireplace.setLocation(10, 525);
		add(l_fireplace);

		l_fireplace2 = new Label("Fireplace2");
		l_fireplace2.setSize(60, 18);
		l_fireplace2.setLocation(91, 525);
		add(l_fireplace2);

		l_hearth = new Label("Cooking Hearth");
		l_hearth.setSize(90, 18);
		l_hearth.setLocation(185, 525);
		add(l_hearth);

		l_hearth2 = new Label("Cooking Hearth2");
		l_hearth2.setSize(95, 18);
		l_hearth2.setLocation(10, 545);
		add(l_hearth2);

		l_coven = new Label("Clay Oven");
		l_coven.setSize(70, 18);
		l_coven.setLocation(125, 545);
		add(l_coven);

		l_soven = new Label("Stone Oven");
		l_soven.setSize(85, 18);
		l_soven.setLocation(202, 548);
		add(l_soven);

		l_joinery = new Label("Joinery");
		l_joinery.setSize(54, 18);
		l_joinery.setLocation(10, 567);
		add(l_joinery);

		l_pottery = new Label("Pottery");
		l_pottery.setSize(50, 18);
		l_pottery.setLocation(75, 567);
		add(l_pottery);

		l_basket = new Label("Basketmaker");
		l_basket.setSize(77, 18);
		l_basket.setLocation(132, 567);
		add(l_basket);

		l_well = new Label("Well");
		l_well.setSize(40, 18);
		l_well.setLocation(228, 567);
		add(l_well);

		l2_fireplace = new Label("Fireplace");
		l2_fireplace.setSize(55, 18);
		l2_fireplace.setLocation(330, 522);
		l2_fireplace.setVisible(false);
		add(l2_fireplace);

		l2_fireplace2 = new Label("Fireplace2");
		l2_fireplace2.setSize(60, 18);
		l2_fireplace2.setLocation(411, 525);
		l2_fireplace2.setVisible(false);
		add(l2_fireplace2);

		l2_hearth = new Label("Cooking Hearth");
		l2_hearth.setSize(90, 18);
		l2_hearth.setLocation(505, 525);
		l2_hearth.setVisible(false);
		add(l2_hearth);

		l2_hearth2 = new Label("Cooking Hearth2");
		l2_hearth2.setSize(95, 18);
		l2_hearth2.setLocation(330, 545);
		l2_hearth2.setVisible(false);
		add(l2_hearth2);

		l2_coven = new Label("Clay Oven");
		l2_coven.setSize(70, 18);
		l2_coven.setLocation(445, 545);
		l2_coven.setVisible(false);
		add(l2_coven);

		l2_soven = new Label("Stone Oven");
		l2_soven.setSize(85, 18);
		l2_soven.setLocation(522, 545);
		l2_soven.setVisible(false);
		add(l2_soven);

		l2_joinery = new Label("Joinery");
		l2_joinery.setSize(54, 18);
		l2_joinery.setLocation(340, 567);
		l2_joinery.setVisible(false);
		add(l2_joinery);

		l2_pottery = new Label("Pottery");
		l2_pottery.setSize(50, 18);
		l2_pottery.setLocation(395, 567);
		l2_pottery.setVisible(false);
		add(l2_pottery);

		l2_basket = new Label("Basketmaker");
		l2_basket.setSize(77, 18);
		l2_basket.setLocation(452, 567);
		l2_basket.setVisible(false);
		add(l2_basket);

		l2_well = new Label("Well");
		l2_well.setSize(40, 18);
		l2_well.setLocation(548, 567);
		l2_well.setVisible(false);
		add(l2_well);

		// , l_fireplace2, l_hearth, l_hearth2, l_coven, l_soven, l_joinery,
		// l_pottery, l_basket, l_well,
		// l2_fireplace, l2_fireplace2, l2_hearth, l2_hearth2, l2_coven,
		// l2_soven, l2_joinery, l2_pottery, l2_basket, l2_well;

		l_tfam = new Label("Total Family:");
		l_tfam.setLocation(5, 480);
		l_tfam.setSize(70, 14);
		add(l_tfam);

		t_tfam = new JTextField("2");
		t_tfam.setToolTipText("playerFam");
		t_tfam.setEditable(false);
		t_tfam.setSize(24, 18);
		t_tfam.setLocation(85, 478);
		t_tfam.setBackground(Color.white);
		add(t_tfam);

		l_fam = new Label("Family Remaining:");
		l_fam.setLocation(120, 480);
		l_fam.setSize(105, 14);
		add(l_fam);

		t_fam = new JTextField("2");
		t_fam.setToolTipText("remFam");
		t_fam.setEditable(false);
		t_fam.setSize(24, 20);
		t_fam.setLocation(230, 478);
		t_fam.setBackground(Color.white);
		add(t_fam);

		l_sheep = new Label("Sheep:");
		l_sheep.setLocation(265, 480);
		l_sheep.setSize(40, 14);
		add(l_sheep);

		p_sheep = new JTextField("0");
		p_sheep.setToolTipText("playerSheep");
		p_sheep.setEditable(false);
		p_sheep.setSize(24, 20);
		p_sheep.setLocation(311, 478);
		p_sheep.setBackground(Color.white);
		add(p_sheep);

		l_boar = new Label("Boar:");
		l_boar.setLocation(347, 480);
		l_boar.setSize(37, 14);
		add(l_boar);

		p_boar = new JTextField("0");
		p_boar.setToolTipText("playerBoar");
		p_boar.setEditable(false);
		p_boar.setSize(24, 20);
		p_boar.setLocation(384, 478);
		p_boar.setBackground(Color.pink);
		add(p_boar);

		l_cattle = new Label("Cattle:");
		l_cattle.setLocation(425, 480);
		l_cattle.setSize(40, 14);
		add(l_cattle);

		p_cattle = new JTextField("0");
		p_cattle.setToolTipText("playerCattle");
		p_cattle.setEditable(false);
		p_cattle.setSize(24, 20);
		p_cattle.setLocation(467, 478);
		p_cattle.setForeground(Color.white);
		p_cattle.setBackground(Color.black);
		add(p_cattle);

		l_pasture = new Label("Animal Space Available: ");
		l_pasture.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 9));
		l_pasture.setLocation(499, 480);
		l_pasture.setSize(110, 14);
		add(l_pasture);

		p_pasture = new JTextField("1");
		p_pasture.setEditable(false);
		p_pasture.setSize(24, 20);
		p_pasture.setLocation(610, 478);
		// p_pasture.setForeground(Color.white);
		p_pasture.setBackground(new Color(135, 206, 250));
		add(p_pasture);

		label_food = new Label("Food:");
		label_food.setLocation(5, 450);
		label_food.setSize(40, 10);
		add(label_food);

		text_food = new JTextField("0");
		text_food.setToolTipText("playerFood");
		text_food.setEditable(false);
		text_food.setLocation(45, 446);
		text_food.setSize(24, 20);
		text_food.setBackground(Color.magenta);
		add(text_food);

		label_reed = new Label("Reed:");
		label_reed.setLocation(96, 450);
		label_reed.setSize(40, 10);
		add(label_reed);

		text_reed = new JTextField("0");
		text_reed.setToolTipText("playerReed");
		text_reed.setEditable(false);
		text_reed.setLocation(136, 446);
		text_reed.setSize(24, 20);
		text_reed.setForeground(Color.white);
		text_reed.setBackground(Color.blue);
		add(text_reed);

		label_wood = new Label("Wood:");
		label_wood.setLocation(180, 450);
		label_wood.setSize(40, 10);
		add(label_wood);

		text_wood = new JTextField("0");
		text_wood.setToolTipText("playerWood");
		text_wood.setEditable(false);
		text_wood.setLocation(220, 446);
		text_wood.setSize(24, 20);
		text_wood.setForeground(Color.white);
		text_wood.setBackground(new Color(139, 69, 19));
		add(text_wood);

		label_clay = new Label("Clay:");
		label_clay.setLocation(264, 447);
		label_clay.setSize(35, 15);
		add(label_clay);

		text_clay = new JTextField("0");
		text_clay.setToolTipText("playerClay");
		text_clay.setEditable(false);
		text_clay.setLocation(299, 446);
		text_clay.setSize(24, 20);
		text_clay.setForeground(Color.white);
		text_clay.setBackground(Color.red);
		add(text_clay);

		label_stone = new Label("Stone:");
		label_stone.setLocation(342, 447);
		label_stone.setSize(35, 15);
		add(label_stone);

		text_stone = new JTextField("0");
		text_stone.setToolTipText("playerStone");
		text_stone.setEditable(false);
		text_stone.setLocation(382, 446);
		text_stone.setSize(24, 20);
		text_stone.setBackground(Color.LIGHT_GRAY);
		add(text_stone);

		label_grain = new Label("Grain:");
		label_grain.setLocation(433, 447);
		label_grain.setSize(35, 15);
		add(label_grain);

		text_grain = new JTextField("0");
		text_grain.setToolTipText("playerGrain");
		text_grain.setEditable(false);
		text_grain.setLocation(479, 446);
		text_grain.setSize(24, 20);
		text_grain.setBackground(Color.yellow);
		add(text_grain);

		label_vege = new Label("Vegetables:");
		label_vege.setLocation(525, 447);
		label_vege.setSize(70, 15);
		add(label_vege);

		text_vege = new JTextField("0");
		text_vege.setToolTipText("playerVege");
		text_vege.setEditable(false);
		text_vege.setLocation(600, 446);
		text_vege.setSize(24, 20);
		text_vege.setBackground(Color.green);
		add(text_vege);

		// b_room, b_start, b_grain, b_field, b_stable, b_day, b_3wood, b_clay,
		// b_reed, b_food, b_improve, b_sow, b_fences, b_sheep, b_renov,
		// b_growth, b_stone, b_boar, b_vege,
		// b_stone, b_cattle, b_fieldsow, b_growth2, b_renov2;

		buttons[0] = new JButton(
				"Build rooms [5 wood/clay/stone and 2 reed] and/or build stables [2 wood]");
		buttons[0].setToolTipText("BuildRoomOrStable");
		buttons[0].setLocation(650, 10);
		buttons[0].setSize(420, 15);
		buttons[0].setFont(new Font("Dialog", 1, 10));
		add(buttons[0]);

		buttons[1] = new JButton("Starting Player and take 1 Food");
		buttons[1].setToolTipText("StartAndFood");
		buttons[1].setLocation(650, 30);
		buttons[1].setSize(420, 15);
		buttons[1].setFont(new Font("Dialog", 1, 10));
		add(buttons[1]);

		buttons[2] = new JButton("Take 1 Grain");
		buttons[2].setToolTipText("Take1Grain");
		buttons[2].setLocation(650, 50);
		buttons[2].setSize(420, 15);
		buttons[2].setFont(new Font("Dialog", 1, 10));
		add(buttons[2]);

		buttons[3] = new JButton("Plow 1 Field");
		buttons[3].setToolTipText("PlowField");
		buttons[3].setLocation(650, 70);
		buttons[3].setSize(420, 15);
		buttons[3].setFont(new Font("Dialog", 1, 10));
		add(buttons[3]);

		buttons[4] = new JButton("Build 1 Stable [1 wood] and/or Bake Bread");
		buttons[4].setToolTipText("BuildStableBakeBread");
		buttons[4].setLocation(650, 90);
		buttons[4].setSize(420, 15);
		buttons[4].setFont(new Font("Dialog", 1, 10));
		add(buttons[4]);

		buttons[5] = new JButton("Take 1 food and 1 wood, clay, reed, or stone");
		buttons[5].setToolTipText("TakeWoodAndOther");
		buttons[5].setLocation(650, 110);
		buttons[5].setSize(420, 15);
		buttons[5].setFont(new Font("Dialog", 1, 10));
		add(buttons[5]);

		buttons[6] = new JButton("Take wood (+3 per round) (+2 in 1p)");
		buttons[6].setToolTipText("Take3Wood");
		buttons[6].setLocation(650, 130);
		buttons[6].setSize(360, 15);
		buttons[6].setFont(new Font("Dialog", 1, 10));
		add(buttons[6]);

		t_wood = new JTextField("3");
		t_wood.setToolTipText("woodSupply");
		t_wood.setEditable(false);
		t_wood.setLocation(1030, 130);
		t_wood.setSize(24, 15);
		t_wood.setForeground(Color.white);
		t_wood.setBackground(new Color(139, 69, 19));
		add(t_wood);

		buttons[7] = new JButton("Take clay (+1 per round)");
		buttons[7].setToolTipText("TakeClay");
		buttons[7].setLocation(650, 150);
		buttons[7].setSize(360, 15);
		buttons[7].setFont(new Font("Dialog", 1, 10));
		add(buttons[7]);

		t_clay = new JTextField("1");
		t_clay.setToolTipText("claySupply");
		t_clay.setEditable(false);
		t_clay.setLocation(1030, 150);
		t_clay.setSize(24, 15);
		t_clay.setForeground(Color.white);
		t_clay.setBackground(Color.red);
		add(t_clay);

		buttons[8] = new JButton("Take reed (+1 per round)");
		buttons[8].setToolTipText("TakeReed");
		buttons[8].setLocation(650, 170);
		buttons[8].setSize(360, 15);
		buttons[8].setFont(new Font("Dialog", 1, 10));
		add(buttons[8]);

		t_reed = new JTextField("1");
		t_reed.setToolTipText("reedCount");
		t_reed.setEditable(false);
		t_reed.setLocation(1030, 170);
		t_reed.setSize(24, 15);
		t_reed.setForeground(Color.white);
		t_reed.setBackground(Color.blue);
		add(t_reed);

		buttons[9] = new JButton("Take food (+1 per round)");
		buttons[9].setToolTipText("TakeFood");
		buttons[9].setLocation(650, 190);
		buttons[9].setSize(360, 15);
		buttons[9].setFont(new Font("Dialog", 1, 10));
		add(buttons[9]);

		t_food = new JTextField("1");
		t_food.setToolTipText("foodSupply");
		t_food.setEditable(false);
		t_food.setLocation(1030, 190);
		t_food.setSize(24, 15);
		t_food.setBackground(Color.magenta);
		add(t_food);

		r1 = new Label("Round 1");
		r1.setFont(new Font("Dialog", 1, 10));
		r1.setLocation(650, 210);
		r1.setSize(40, 12);
		add(r1);

		buttons[10] = new JButton("Take sheep (+1 per round)");
		buttons[10].setToolTipText("TakeSheep");
		buttons[10].setLocation(700, 210);
		buttons[10].setSize(310, 15);
		buttons[10].setFont(new Font("Dialog", 1, 10));
		add(buttons[10]);

		t_sheep = new JTextField("1");
		t_sheep.setToolTipText("sheepSupply");
		t_sheep.setEditable(false);
		t_sheep.setLocation(1030, 210);
		t_sheep.setSize(24, 15);
		t_sheep.setBackground(Color.white);
		add(t_sheep);

		r2 = new Label("Round 2");
		r2.setFont(new Font("Dialog", 1, 10));
		r2.setLocation(650, 230);
		r2.setSize(43, 12);
		add(r2);

		buttons[11] = new JButton("Sow and/or Bake bread");
		buttons[11].setToolTipText("SowAndBread");
		buttons[11].setLocation(700, 230);
		buttons[11].setSize(370, 15);
		buttons[11].setFont(new Font("Dialog", 1, 10));
		add(buttons[11]);

		r3 = new Label("Round 3");
		r3.setFont(new Font("Dialog", 1, 10));
		r3.setLocation(650, 250);
		r3.setSize(43, 12);
		add(r3);

		buttons[12] = new JButton("Build Fences [1 wood per fence]");
		buttons[12].setToolTipText("BuildFences");
		buttons[12].setLocation(700, 250);
		buttons[12].setSize(370, 15);
		buttons[12].setFont(new Font("Dialog", 1, 10));
		add(buttons[12]);

		r4 = new Label("Round 4");
		r4.setFont(new Font("Dialog", 1, 10));
		r4.setLocation(650, 270);
		r4.setSize(43, 13);
		add(r4);

		buttons[13] = new JButton("Buy 1 Major Improvement");
		buttons[13].setToolTipText("MajImprove");
		buttons[13].setLocation(700, 270);
		buttons[13].setSize(370, 15);
		buttons[13].setFont(new Font("Dialog", 1, 10));
		add(buttons[13]);

		buttons[24] = new JButton("Finish Action");
		buttons[24].setToolTipText("FinishActionFences");
		buttons[24].setLocation(510, 60);
		buttons[24].setSize(127, 30);
		buttons[24].setFont(new Font("Dialog", 1, 10));
		buttons[24].setVisible(false);
		add(buttons[24]);

		l_harvest1 = new Label(
				"----------------------------------------------------------------harvest----------------------------------------------------------------");
		l_harvest1.setFont(new Font("Dialog", 1, 10));
		l_harvest1.setLocation(650, 285);
		l_harvest1.setSize(420, 12);
		add(l_harvest1);

		r5 = new Label("Round 5");
		r5.setFont(new Font("Dialog", 1, 10));
		r5.setLocation(650, 300);
		r5.setSize(43, 12);
		add(r5);

		buttons[14] = new JButton("Take 1 stone (+1 per round)");
		buttons[14].setToolTipText("Take1Stone");
		buttons[14].setLocation(700, 300);
		buttons[14].setSize(310, 15);
		buttons[14].setFont(new Font("Dialog", 1, 10));
		add(buttons[14]);

		t_stone = new JTextField("1");
		t_stone.setToolTipText("1stoneSupply");
		t_stone.setEditable(false);
		t_stone.setLocation(1030, 300);
		t_stone.setSize(24, 15);
		// t_stone.setForeground(Color.white);
		t_stone.setBackground(Color.LIGHT_GRAY);
		t_stone.setVisible(false);
		add(t_stone);

		r6 = new Label("Round 6");
		r6.setFont(new Font("Dialog", 1, 10));
		r6.setLocation(650, 320);
		r6.setSize(43, 12);
		add(r6);

		buttons[15] = new JButton("Family Growth (after round)");
		buttons[15].setToolTipText("FamGrowth");
		buttons[15].setLocation(700, 320);
		buttons[15].setSize(370, 15);
		buttons[15].setFont(new Font("Dialog", 1, 10));
		add(buttons[15]);

		r7 = new Label("Round 7");
		r7.setFont(new Font("Dialog", 1, 10));
		r7.setLocation(650, 340);
		r7.setSize(43, 12);
		add(r7);

		buttons[16] = new JButton(
				"Renovate [1 reed plus 1 clay/stone per room] also 1 Major Improvement");
		buttons[16].setToolTipText("RenovateAndImprove");
		buttons[16].setLocation(700, 340);
		buttons[16].setSize(370, 15);
		buttons[16].setFont(new Font("Dialog", 1, 10));
		add(buttons[16]);

		l_harvest2 = new Label(
				"----------------------------------------------------------------harvest----------------------------------------------------------------");
		l_harvest2.setFont(new Font("Dialog", 1, 10));
		l_harvest2.setLocation(650, 355);
		l_harvest2.setSize(420, 12);
		add(l_harvest2);

		r8 = new Label("Round 6");
		r8.setFont(new Font("Dialog", 1, 10));
		r8.setLocation(650, 370);
		r8.setSize(43, 12);
		add(r8);

		buttons[17] = new JButton("Take wild boar (+1 per turn)");
		buttons[17].setToolTipText("TakeBoar");
		buttons[17].setLocation(700, 370);
		buttons[17].setSize(310, 15);
		buttons[17].setFont(new Font("Dialog", 1, 10));
		add(buttons[17]);

		t_boar = new JTextField("1");
		t_boar.setToolTipText("boarSupply");
		t_boar.setEditable(false);
		t_boar.setLocation(1030, 370);
		t_boar.setSize(24, 15);
		// t_boar.setForeground(Color.white);
		t_boar.setBackground(Color.pink);
		t_boar.setVisible(false);
		add(t_boar);

		r9 = new Label("Round 9");
		r9.setFont(new Font("Dialog", 1, 10));
		r9.setLocation(650, 390);
		r9.setSize(43, 12);
		add(r9);

		buttons[18] = new JButton("Take 1 vegetable");
		buttons[18].setToolTipText("TakeVege");
		buttons[18].setLocation(700, 390);
		buttons[18].setSize(370, 15);
		buttons[18].setFont(new Font("Dialog", 1, 10));
		add(buttons[18]);

		l_harvest3 = new Label(
				"----------------------------------------------------------------harvest----------------------------------------------------------------");
		l_harvest3.setFont(new Font("Dialog", 1, 10));
		l_harvest3.setLocation(650, 405);
		l_harvest3.setSize(420, 12);
		add(l_harvest3);

		r10 = new Label("Round 10");
		r10.setFont(new Font("Dialog", 1, 10));
		r10.setLocation(650, 420);
		r10.setSize(47, 12);
		add(r10);

		buttons[19] = new JButton("Take cattle (+1 per turn)");
		buttons[19].setToolTipText("TakeCattle");
		buttons[19].setLocation(700, 420);
		buttons[19].setSize(310, 15);
		buttons[19].setFont(new Font("Dialog", 1, 10));
		add(buttons[19]);

		t_cattle = new JTextField("1");
		t_cattle.setToolTipText("cattleSupply");
		t_cattle.setEditable(false);
		t_cattle.setLocation(1030, 420);
		t_cattle.setSize(24, 15);
		t_cattle.setForeground(Color.white);
		t_cattle.setBackground(Color.black);
		t_cattle.setVisible(false);
		add(t_cattle);

		r11 = new Label("Round 11");
		r11.setFont(new Font("Dialog", 1, 10));
		r11.setLocation(650, 440);
		r11.setSize(47, 12);
		add(r11);

		buttons[20] = new JButton("Take stone(+1 per turn)");
		buttons[20].setToolTipText("ButtonTakeStone");
		buttons[20].setLocation(700, 440);
		buttons[20].setSize(310, 15);
		buttons[20].setFont(new Font("Dialog", 1, 10));
		add(buttons[20]);

		t_stone2 = new JTextField("1");
		t_stone2.setToolTipText("stoneSupply");
		t_stone2.setEditable(false);
		t_stone2.setLocation(1030, 440);
		t_stone2.setSize(24, 15);
		// t_stone2.setForeground(Color.white);
		t_stone2.setBackground(Color.LIGHT_GRAY);
		t_stone2.setVisible(false);
		add(t_stone2);

		l_harvest4 = new Label(
				"----------------------------------------------------------------harvest----------------------------------------------------------------");
		l_harvest4.setFont(new Font("Dialog", 1, 10));
		l_harvest4.setLocation(650, 455);
		l_harvest4.setSize(420, 12);
		add(l_harvest4);

		r12 = new Label("Round 12");
		r12.setFont(new Font("Dialog", 1, 10));
		r12.setLocation(650, 470);
		r12.setSize(47, 12);
		add(r12);

		buttons[21] = new JButton(
				"Family Growth (even without space in your home)");
		buttons[21].setToolTipText("FamGrowthNoSpace");
		buttons[21].setLocation(700, 470);
		buttons[21].setSize(370, 15);
		buttons[21].setFont(new Font("Dialog", 1, 10));
		add(buttons[21]);

		r13 = new Label("Round 13");
		r13.setFont(new Font("Dialog", 1, 10));
		r13.setLocation(650, 490);
		r13.setSize(47, 12);
		add(r13);

		buttons[22] = new JButton("Plow 1 Field and/or Sow");
		buttons[22].setToolTipText("PlowOrSow");
		buttons[22].setLocation(700, 490);
		buttons[22].setSize(370, 15);
		buttons[22].setFont(new Font("Dialog", 1, 10));
		add(buttons[22]);

		l_harvest5 = new Label(
				"----------------------------------------------------------------harvest----------------------------------------------------------------");
		l_harvest5.setFont(new Font("Dialog", 1, 10));
		l_harvest5.setLocation(650, 505);
		l_harvest5.setSize(420, 12);
		add(l_harvest5);

		r14 = new Label("Round 14");
		r14.setFont(new Font("Dialog", 1, 10));
		r14.setLocation(650, 525);
		r14.setSize(47, 13);
		add(r14);

		buttons[23] = new JButton(
				"Renovate (1 reed plus 1 clay/stone per room) also Fences [1 wood]");
		buttons[23].setToolTipText("RenovateAndFences");
		buttons[23].setLocation(700, 525);
		buttons[23].setSize(370, 15);
		buttons[23].setFont(new Font("Dialog", 1, 10));
		add(buttons[23]);

		l_harvest6 = new Label(
				"----------------------------------------------------------------harvest----------------------------------------------------------------");
		l_harvest6.setFont(new Font("Dialog", 1, 10));
		l_harvest6.setLocation(650, 540);
		l_harvest6.setSize(420, 12);
		add(l_harvest6);

		getSpaceTypes = new JTextField(
				"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeweeeeeeeeeeeeeeeeeeeeeweeeeeeeeeeeeeeeeeeee");
		getSpaceTypes.setLocation(650, 565);
		getSpaceTypes.setSize(420, 15);
		getSpaceTypes.setToolTipText("GetSpaceTypes");
		add(getSpaceTypes);

		/*
		 * button_admin=new JButton("Administrator");
		 * button_admin.setLocation(650,490); button_admin.setSize(180,40);
		 * add(button_admin);
		 */

		// 3 PLAYER ONLY BUTTONS

		buttons3[0] = new JButton("(3p) Clay (+1 per round)");
		buttons3[0].setLocation(3, 3);
		buttons3[0].setSize(280, 15);
		buttons3[0].setFont(new Font("Dialog", 1, 10));
		buttons3[0].setVisible(false);
		add(buttons3[0]);

		t3_clay = new JTextField("1");
		t3_clay.setEditable(false);
		t3_clay.setLocation(288, 3);
		t3_clay.setSize(24, 15);
		t3_clay.setForeground(Color.white);
		t3_clay.setBackground(Color.red);
		t3_clay.setVisible(false);
		add(t3_clay);

		buttons3[1] = new JButton("(3p) Wood (+2 per round)");
		buttons3[1].setLocation(335, 3);
		buttons3[1].setSize(280, 15);
		buttons3[1].setFont(new Font("Dialog", 1, 10));
		buttons3[1].setVisible(false);
		add(buttons3[1]);

		t3_wood = new JTextField("2");
		t3_wood.setEditable(false);
		t3_wood.setLocation(620, 3);
		t3_wood.setSize(24, 15);
		t3_wood.setForeground(Color.white);
		t3_wood.setBackground(new Color(139, 69, 19));
		t3_wood.setVisible(false);
		add(t3_wood);

		buttons3[2] = new JButton("(3p) 1 Building Resource");
		buttons3[2].setLocation(3, 21);
		buttons3[2].setSize(310, 15);
		buttons3[2].setFont(new Font("Dialog", 1, 10));
		buttons3[2].setVisible(false);
		add(buttons3[2]);

		buttons3[3] = new JButton("(3p) 2 Different Building Resources");
		buttons3[3].setLocation(335, 21);
		buttons3[3].setSize(310, 15);
		buttons3[3].setFont(new Font("Dialog", 1, 10));
		buttons3[3].setVisible(false);
		add(buttons3[3]);

		// 4 PLAYER ONLY BUTTONS

		buttons4[0] = new JButton("(4p) Wood (+1 per round)");
		buttons4[0].setLocation(3, 3);
		buttons4[0].setSize(280, 15);
		buttons4[0].setFont(new Font("Dialog", 1, 10));
		buttons4[0].setVisible(false);
		add(buttons4[0]);

		t4_wood = new JTextField("1");
		t4_wood.setEditable(false);
		t4_wood.setLocation(290, 3);
		t4_wood.setSize(24, 15);
		t4_wood.setForeground(Color.white);
		t4_wood.setBackground(new Color(139, 69, 19));
		t4_wood.setVisible(false);
		add(t4_wood);

		buttons4[1] = new JButton("(4p) Clay (+2 per round)");
		buttons4[1].setLocation(330, 3);
		buttons4[1].setSize(280, 15);
		buttons4[1].setFont(new Font("Dialog", 1, 10));
		buttons4[1].setVisible(false);
		add(buttons4[1]);

		t4_clay = new JTextField("2");
		t4_clay.setEditable(false);
		t4_clay.setLocation(620, 3);
		t4_clay.setSize(24, 15);
		t4_clay.setForeground(Color.white);
		t4_clay.setBackground(Color.red);
		t4_clay.setVisible(false);
		add(t4_clay);

		buttons4[2] = new JButton("(4p) Wood (+2 per round)");
		buttons4[2].setLocation(3, 23);
		buttons4[2].setSize(280, 15);
		buttons4[2].setFont(new Font("Dialog", 1, 10));
		buttons4[2].setVisible(false);
		add(buttons4[2]);

		t4_2wood = new JTextField("2");
		t4_2wood.setEditable(false);
		t4_2wood.setLocation(290, 23);
		t4_2wood.setSize(24, 15);
		t4_2wood.setForeground(Color.white);
		t4_2wood.setBackground(new Color(139, 69, 19));
		t4_2wood.setVisible(false);
		add(t4_2wood);

		buttons4[3] = new JButton("(4p) Food (+1 per round)");
		buttons4[3].setLocation(330, 23);
		buttons4[3].setSize(280, 15);
		buttons4[3].setFont(new Font("Dialog", 1, 10));
		buttons4[3].setVisible(false);
		add(buttons4[3]);

		t4_food = new JTextField("1");
		t4_food.setEditable(false);
		t4_food.setLocation(620, 23);
		t4_food.setSize(24, 15);
		// t4_2wood.setForeground(Color.white);
		t4_food.setBackground(Color.magenta);
		t4_food.setVisible(false);
		add(t4_food);

		buttons4[4] = new JButton("(4p) 2 Different Building Resources");
		buttons4[4].setLocation(3, 43);
		buttons4[4].setSize(314, 15);
		buttons4[4].setFont(new Font("Dialog", 1, 10));
		buttons4[4].setVisible(false);
		add(buttons4[4]);

		buttons4[5] = new JButton("(4p) 1 reed, stone & food");
		buttons4[5].setLocation(330, 43);
		buttons4[5].setSize(314, 15);
		buttons4[5].setFont(new Font("Dialog", 1, 10));
		buttons4[5].setVisible(false);
		add(buttons4[5]);

		// 5 PLAYER ONLY BUTTONS

		buttons5[0] = new JButton("(5p) Wood (+4 per round)");
		buttons5[0].setLocation(3, 3);
		buttons5[0].setSize(280, 15);
		buttons5[0].setFont(new Font("Dialog", 1, 10));
		buttons5[0].setVisible(false);
		add(buttons5[0]);

		t5_wood = new JTextField("4");
		t5_wood.setEditable(false);
		t5_wood.setLocation(290, 3);
		t5_wood.setSize(24, 15);
		t5_wood.setForeground(Color.white);
		t5_wood.setBackground(new Color(139, 69, 19));
		t5_wood.setVisible(false);
		add(t5_wood);

		buttons5[1] = new JButton("(5p) Clay (+3 per round)");
		buttons5[1].setLocation(330, 3);
		buttons5[1].setSize(280, 15);
		buttons5[1].setFont(new Font("Dialog", 1, 10));
		buttons5[1].setVisible(false);
		add(buttons5[1]);

		t5_clay = new JTextField("3");
		t5_clay.setEditable(false);
		t5_clay.setLocation(620, 3);
		t5_clay.setSize(24, 15);
		t5_clay.setForeground(Color.white);
		t5_clay.setBackground(Color.red);
		t5_clay.setVisible(false);
		add(t5_clay);

		buttons5[2] = new JButton(
				"(5p) Build 1 room or take Food (+1 per round)");
		buttons5[2].setLocation(3, 23);
		buttons5[2].setSize(280, 15);
		buttons5[2].setFont(new Font("Dialog", 1, 10));
		buttons5[2].setVisible(false);
		add(buttons5[2]);

		t5_food = new JTextField("1");
		t5_food.setEditable(false);
		t5_food.setLocation(290, 23);
		t5_food.setSize(24, 15);
		// t5_2wood.setForeground(Color.white);
		t5_food.setBackground(Color.magenta);
		t5_food.setVisible(false);
		add(t5_food);

		buttons5[3] = new JButton(
				"(5p) Take Reed (+1 per round) & 1 stone + 1 wood");
		buttons5[3].setLocation(330, 23);
		buttons5[3].setSize(280, 15);
		buttons5[3].setFont(new Font("Dialog", 1, 10));
		buttons5[3].setVisible(false);
		add(buttons5[3]);

		t5_reed = new JTextField("1");
		t5_reed.setEditable(false);
		t5_reed.setLocation(620, 23);
		t5_reed.setSize(24, 15);
		t5_reed.setForeground(Color.white);
		t5_reed.setBackground(Color.blue);
		t5_reed.setVisible(false);
		add(t5_reed);

		buttons5[4] = new JButton(
				"(5p) Take Animal - sheep gives 1 food, cattle costs 1");
		buttons5[4].setLocation(3, 43);
		buttons5[4].setSize(314, 15);
		buttons5[4].setFont(new Font("Dialog", 1, 10));
		buttons5[4].setVisible(false);
		add(buttons5[4]);

		buttons5[5] = new JButton(
				"(5p) 2 Different Building Resources or Family Growth");
		buttons5[5].setLocation(330, 43);
		buttons5[5].setSize(314, 15);
		buttons5[5].setFont(new Font("Dialog", 1, 10));
		buttons5[5].setVisible(false);
		add(buttons5[5]);

		menu = new JMenuBar();
		setJMenuBar(menu);
		gmenu = new JMenu("Player");
		gmenu.setMnemonic(KeyEvent.VK_G);
		menu.add(gmenu);

		playergroup = new ButtonGroup();

		player1 = new JRadioButtonMenuItem("Player 1");
		player1.setSelected(true);
		gmenu.add(player1);
		playergroup.add(player1);

		panel_farm = new FarmPanel(new Farm());
		panel_farm.setSize(630, 348);
		panel_farm.setLocation(7, 95);
		add(panel_farm);

	}

	public Space[][] getFarm() {
		return panel_farm.getFarm();
	}

	public JButton[] getActions() {
		return buttons;
	}

	public JButton[] get3Actions() {
		return buttons3;
	}

	public JButton[] get4Actions() {
		return buttons4;
	}

	public JButton[] get5Actions() {
		return buttons5;
	}

	// public JButton getAdmin(){
	// return button_admin;
	// }

	public JButton[][] getButtons() {
		return panel_farm.getButtons();
	}

	public JRadioButtonMenuItem[] getRadio() {
		JRadioButtonMenuItem[] allradio = { player1, player2, player3, player4,
				player5 };
		return allradio;
	}

	public JRadioButtonMenuItem getPlayer1() {
		return player1;
	}

	public JRadioButtonMenuItem getPlayer2() {
		return player2;
	}

	public JRadioButtonMenuItem getPlayer3() {
		return player3;
	}

	public JRadioButtonMenuItem getPlayer4() {
		return player4;
	}

	public JRadioButtonMenuItem getPlayer5() {
		return player5;
	}

	public JTextField[] getPlayerTexts() {
		JTextField[] alltext = { text_food, text_reed, text_wood, text_clay,
				text_stone, text_grain, text_vege, t_tfam, t_fam, p_sheep,
				p_boar, p_cattle, p_pasture };
		return alltext;
	}

	public Label[] getGameImprovements() {
		Label[] allImprovements = { l_fireplace, l_fireplace2, l_hearth,
				l_hearth2, l_coven, l_soven, l_joinery, l_pottery, l_basket,
				l_well };
		return allImprovements;

	}

	public Label[] getPlayerImprovements() {
		Label[] allImprovements = { l2_fireplace, l2_fireplace2, l2_hearth,
				l2_hearth2, l2_coven, l2_soven, l2_joinery, l2_pottery,
				l2_basket, l2_well };
		return allImprovements;

	}

	public void setPlayerMenu(int n) {
		if (n > 1) {

			player2 = new JRadioButtonMenuItem("Player 2");
			gmenu.add(player2);
			playergroup.add(player2);

			if (n > 2) {
				player3 = new JRadioButtonMenuItem("Player 3");
				gmenu.add(player3);
				playergroup.add(player3);

				if (n > 3) {
					player4 = new JRadioButtonMenuItem("Player 4");
					gmenu.add(player4);
					playergroup.add(player4);

					if (n > 4) {
						player5 = new JRadioButtonMenuItem("Player 5");
						gmenu.add(player5);
						playergroup.add(player5);
					}
				}
			}
		}
	}

	public JTextField[] getGameTexts() {
		JTextField[] alltext = { text_turn, t_wood, t_clay, t_reed, t_food,
				t_sheep, t_stone, t_boar, t_cattle, t_stone2, t_cur, t_star,
				t_viewer };
		return alltext;
	}

	public JTextField[] get3Texts() {
		JTextField[] alltext = { t3_wood, t3_clay };
		return alltext;
	}

	public JTextField[] get4Texts() {
		JTextField[] alltext = { t4_wood, t4_2wood, t4_clay, t4_food };
		return alltext;
	}

	public JTextField[] get5Texts() {
		JTextField[] alltext = { t5_reed, t5_food, t5_clay, t5_wood };
		return alltext;
	}

}
