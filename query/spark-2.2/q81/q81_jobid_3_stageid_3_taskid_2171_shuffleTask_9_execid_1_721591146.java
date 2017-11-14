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
/* 014 */     result = new UnsafeRow(2);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 32);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 2);
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
/* 037 */     boolean isNull = i.isNullAt(0);
/* 038 */     int value = isNull ? -1 : (i.getInt(0));
/* 039 */     if (isNull) {
/* 040 */       rowWriter.setNullAt(0);
/* 041 */     } else {
/* 042 */       rowWriter.write(0, value);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull1 = i.isNullAt(1);
/* 047 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 048 */     if (isNull1) {
/* 049 */       rowWriter.setNullAt(1);
/* 050 */     } else {
/* 051 */       rowWriter.write(1, value1);
/* 052 */     }
/* 053 */     result.setTotalSize(holder.totalSize());
/* 054 */     return result;
/* 055 */   }
/* 056 */ }
