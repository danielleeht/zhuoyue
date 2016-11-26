/**
 * Created by lihaitao on 2016/11/17.
 */
export class Pageable {

  constructor(
    public page: number,

    public size?: number,

    public sort?: string
  ){}

  // public toUrlParam(){
  //   let urlParam = "page="+this.page;
  //   if(this.size) urlParam += "&size="+this.size;
  //   if(this.sort) urlParam += "&sort="+this.sort;
  //
  //   return urlParam;
  // }
}
