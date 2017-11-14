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
/* 014 */     result = new UnsafeRow(6);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 32);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 6);
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_1(InternalRow i) {
/* 026 */
/* 027 */
/* 028 */     double value4 = i.getDouble(4);
/* 029 */     rowWriter.write(4, value4);
/* 030 */
/* 031 */
/* 032 */     double value5 = i.getDouble(5);
/* 033 */     rowWriter.write(5, value5);
/* 034 */
/* 035 */   }
/* 036 */
/* 037 */
/* 038 */   private void apply_0(InternalRow i) {
/* 039 */
/* 040 */
/* 041 */     boolean isNull = i.isNullAt(0);
/* 042 */     int value = isNull ? -1 : (i.getInt(0));
/* 043 */     if (isNull) {
/* 044 */       rowWriter.setNullAt(0);
/* 045 */     } else {
/* 046 */       rowWriter.write(0, value);
/* 047 */     }
/* 048 */
/* 049 */
/* 050 */     boolean isNull1 = i.isNullAt(1);
/* 051 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 052 */     if (isNull1) {
/* 053 */       rowWriter.setNullAt(1);
/* 054 */     } else {
/* 055 */       rowWriter.write(1, value1);
/* 056 */     }
/* 057 */
/* 058 */
/* 059 */     boolean isNull2 = i.isNullAt(2);
/* 060 */     double value2 = isNull2 ? -1.0 : (i.getDouble(2));
/* 061 */     if (isNull2) {
/* 062 */       rowWriter.setNullAt(2);
/* 063 */     } else {
/* 064 */       rowWriter.write(2, value2);
/* 065 */     }
/* 066 */
/* 067 */
/* 068 */     boolean isNull3 = i.isNullAt(3);
/* 069 */     double value3 = isNull3 ? -1.0 : (i.getDouble(3));
/* 070 */     if (isNull3) {
/* 071 */       rowWriter.setNullAt(3);
/* 072 */     } else {
/* 073 */       rowWriter.write(3, value3);
/* 074 */     }
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */
/* 079 */   // Scala.Function1 need this
/* 080 */   public java.lang.Object apply(java.lang.Object row) {
/* 081 */     return apply((InternalRow) row);
/* 082 */   }
/* 083 */
/* 084 */   public UnsafeRow apply(InternalRow i) {
/* 085 */     holder.reset();
/* 086 */
/* 087 */     rowWriter.zeroOutNullBytes();
/* 088 */     apply_0(i);
/* 089 */     apply_1(i);
/* 090 */     result.setTotalSize(holder.totalSize());
/* 091 */     return result;
/* 092 */   }
/* 093 */ }
