/**
 * Created by lihaitao on 2016/11/16.
 */

export class BookCatalog {

  constructor(
    public id: number,

    public crawledBookId: number,

    public itemId: string,

    public name: string,

    public cover: string,

    public category: string,

    public site: string,

    public shopName: string,

    public crawledDate: Date,

    public catalogStatus: CatalogStatus
  ){}
}

enum CatalogStatus {
  /**
   * 已收录
   */
  RECORDED,
  /**
   * 放弃收录
   */
  ABANDONED,
  /**
   * 爬虫完成
   */
  CATALOGED,
  /**
   * 已抓取条目详细信息
   */
  DETAILED
};
