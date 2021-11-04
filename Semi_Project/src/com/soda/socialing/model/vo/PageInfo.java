package com.soda.socialing.model.vo;

public class PageInfo {
	private int page;				// 사용자가 요청하는 페이지
	private int listCount;			// 전체 게시글 수
	private int pageLimit;			// 하단에 보여질 페이지 목록 수 (설정 값)
	private int boardLimit;			// 한 페이지에 보여질 게시글 최대 수 (설정 값)
	private int maxPage;			// 전체 페이지에서 가장 마지막 페이지 (계산 값)
	private int startPage;			// 하단에 보여질 페이지 목록 시작 값 (계산 값)
	private int endPage;			// 하단에 보여질 페이지 목록 끝 값 
	
	// 페이징 처리 계산에 필요한 값을 받아 start, end, maxPage 계산하여 값 설정하기
		public PageInfo(int page, int listCount, int pageLimit, int boardLimit) {
			this.page = page;
			this.listCount = listCount;
			this.pageLimit = pageLimit;
			this.boardLimit = boardLimit;
			
			// * maxPage : 전체 페이지에서 가장 마지막 페이지
			// 게시글 개수가 105면 페이지 수는 자투리 5개까지 한 페이지로 생각해서 11페이지가 필요함
			// => 전체 게시글 수 / 한 페이지에 보여질 개수 결과를 올림처리 
			this.maxPage = (int)(Math.ceil((double)listCount / boardLimit));		
			// int / int = int이기 때문에 소수점 날아가는거 방지하기 위해 (double)로 형변환
			// Math.ceil로 올림처리 후 maxPage는 int 타입이기 때문에 (int)로 다시 형변환
			
			// * startPage : 하단에 보여질 페이지 목록 시작 값 (한 목록당 5페이지씩 이기 때문에 1~5 6~10 11~15..)
			// 요청 page에서 pageLimit만큼을 나누고 (소수점은 날아가고 정수만 남음) 다시 pageLimit을 곱한 뒤 1을 더함 
				// 5 / 10 * 10 + 1 => 1
				// 15 / 10 * 10 + 1 => 11
				// 25 / 10 * 10 + 1 => 21
			// 10, 20, 30, .. 의 경우 나누었을 때 몫이 하나 더 늘어남
			// 이를 방지하기 위해 page - 1을 함
			this.startPage = (page - 1 ) / pageLimit * pageLimit + 1;
			
			// * endPAge : 하단에 보여질 페이지 목록 끝 값
			this.endPage = startPage + pageLimit - 1;
			
			// 마지막 페이지 수가 총 페이지 수 보다 클 수 없으므로 
			if(this.maxPage < this.endPage)		// 105개의 글이 있을 때 목록은 1~10과 11 페이지만 출력되기 때문에 
				this.endPage = this.maxPage;
		}

		public PageInfo(int page, int listCount, int pageLimit, int boardLimit, int maxPage, int startPage,
				int endPage) {
			super();
			this.page = page;
			this.listCount = listCount;
			this.pageLimit = pageLimit;
			this.boardLimit = boardLimit;
			this.maxPage = maxPage;
			this.startPage = startPage;
			this.endPage = endPage;
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getListCount() {
			return listCount;
		}

		public void setListCount(int listCount) {
			this.listCount = listCount;
		}

		public int getPageLimit() {
			return pageLimit;
		}

		public void setPageLimit(int pageLimit) {
			this.pageLimit = pageLimit;
		}

		public int getBoardLimit() {
			return boardLimit;
		}

		public void setBoardLimit(int boardLimit) {
			this.boardLimit = boardLimit;
		}

		public int getMaxPage() {
			return maxPage;
		}

		public void setMaxPage(int maxPage) {
			this.maxPage = maxPage;
		}

		public int getStartPage() {
			return startPage;
		}

		public void setStartPage(int startPage) {
			this.startPage = startPage;
		}

		public int getEndPage() {
			return endPage;
		}

		public void setEndPage(int endPage) {
			this.endPage = endPage;
		}

		@Override
		public String toString() {
			return "PageInfo [page=" + page + ", listCount=" + listCount + ", pageLimit=" + pageLimit + ", boardLimit="
					+ boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage=" + endPage + "]";
		}
		
}
