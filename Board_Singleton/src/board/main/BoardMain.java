package board.main;

import java.util.List;
import java.util.Scanner;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import board.vo.BoardVO;

public class BoardMain {
  
	private BoardService bService;
	
	public BoardMain() {
		bService = new BoardServiceImpl();
	}
	
	private Scanner scan = new Scanner(System.in); 
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체 목록 출력");
		System.out.println("  2. 새글작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = Integer.parseInt((scan.nextLine())); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 전체 목록 출력
					displayPostAll();
					break;
				case 2 :  // 새글작성
					insertPost();
					break;
				case 3 :  // 수정
					updatePost();
					break;
				case 4 :  // 삭제
					deletePost();
					break;
				case 5 :  // 검색
					selectPost();
					break;
				case 6 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=6);
	}
	
	private void updatePost() {
		
		System.out.println("수정할 게시판 번호를 입력해 주세요.");
		int boardNo = Integer.parseInt(scan.nextLine());
		
		System.out.println("새로운 제목을 입력해 주세요.");
		String newTitle = scan.nextLine();
		System.out.println("새로운 작성자를 입력해 주세요.");
		String newWriter = scan.nextLine();
		System.out.println("새로운 날짜를 입력해 주세요.");
		String newDate = scan.nextLine();
		System.out.println("새로운 내용을 입력해 주세요.");
		String newContent = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(newTitle);
		bv.setBoardWriter(newWriter);
		bv.setBoardDate(newDate);
		bv.setBoardContent(newContent);
		
		int cnt = bService.updatePost(bv);
		
		if(cnt > 0) {
			System.out.println("업데이트가 완료되었습니다.");
		} else {
			System.out.println("업데이트에 실패하였습니다.");
		}
		
		
	}

	private void deletePost() {
		
		System.out.println("삭제할 게시판 번호를 입력해 주세요.");
		int boardNo = Integer.parseInt(scan.nextLine());
		
		int cnt = bService.deletePost(boardNo);
		
		if(cnt > 0) {
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("삭제에 실패하였습니다.");
		}
		
	}

	private void selectPost() {
		
		System.out.println("조회할 게시판 번호를 입력해 주세요.");
		int boardNo = Integer.parseInt(scan.nextLine());
		
		
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		
		List<BoardVO> bList = bService.selectPost(bv);
		
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println(" 번 호\t제 목\t작성자\t작성날짜");
		System.out.println("---------------------------------------------");
		
		if(bList.size() == 0) {
			System.out.println("검색된 회원정보가 없습니다.");
		} else {
			for (BoardVO bv2 : bList) {
				System.out.println(bv2.getBoardNo() + "\t" + bv2.getBoardTitle() + "\t" + bv2.getBoardWriter() + "\t" + bv2.getBoardDate() +"\n"
						+ "\n내용\n\n" + bv2.getBoardContent());
			}
		}
		System.out.println("---------------------------------------------");
		
		
	}

	private void insertPost() {
		
		System.out.println("제목을 입력해 주세요.");
		String title = scan.nextLine();
		System.out.println("작성자를 입력해 주세요.");
		String writer = scan.nextLine();
		System.out.println("날짜를 입력해 주세요. (8자리 숫자)");
		String date = scan.nextLine();
		System.out.println("내용을 입력해 주세요.");
		String content = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoardTitle(title);
		bv.setBoardWriter(writer);
		bv.setBoardDate(date);
		bv.setBoardContent(content);
		
		int cnt = bService.insertPost(bv);
		
		if(cnt > 0) {
			System.out.println("게시물이 작성 되었습니다.");
		} else {
			System.out.println("게시물 작성에 실패하였습니다.");
		}
		
		
	}

	private void displayPostAll() {
		
		System.out.println();
		System.out.println("---------------------------------------------");
		System.out.println(" 번 호\t제 목\t작성자\t작성날짜");
		System.out.println("---------------------------------------------");
		
		List<BoardVO> bList = bService.displayPostAll();
		
		if(bList.size() == 0) {
			System.out.println("출력할 회원정보가 없습니다.");
		} else {
			for (BoardVO bv : bList) {
				System.out.println(bv.getBoardNo() + "\t" + bv.getBoardTitle() + "\t" + bv.getBoardWriter() + "\t" + bv.getBoardDate());
			}
		}
		
		
	}

	public static void main(String[] args) {
		BoardMain board = new BoardMain();
		board.start();
	}
}
