/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */
/* 012 */   public SpecificUnsafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     result = new UnsafeRow(1);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 32);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */
/* 026 */   // Scala.Function1 need this
/* 027 */   public java.lang.Object apply(java.lang.Object row) {
/* 028 */     return apply((InternalRow) row);
/* 029 */   }
/* 030 */
/* 031 */   public UnsafeRow apply(InternalRow i) {
/* 032 */     holder.reset();
/* 033 */
/* 034 */     rowWriter.zeroOutNullBytes();
/* 035 */
/* 036 */
/* 037 */     boolean isNull1 = i.isNullAt(0);
/* 038 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(0));
/* 039 */     boolean isNull = isNull1;
/* 040 */     UTF8String value = value1;
/* 041 */     if (isNull) {
/* 042 */
/* 043 */       Object obj = ((Expression) references[0]).eval(null);
/* 044 */       UTF8String value2 = (UTF8String) obj;
/* 045 */       if (!false) {
/* 046 */         isNull = false;
/* 047 */         value = value2;
/* 048 */       }
/* 049 */     }
/* 050 */     if (isNull) {
/* 051 */       rowWriter.setNullAt(0);
/* 052 */     } else {
/* 053 */       rowWriter.write(0, value);
/* 054 */     }
/* 055 */     result.setTotalSize(holder.totalSize());
/* 056 */     return result;
/* 057 */   }
/* 058 */ }
