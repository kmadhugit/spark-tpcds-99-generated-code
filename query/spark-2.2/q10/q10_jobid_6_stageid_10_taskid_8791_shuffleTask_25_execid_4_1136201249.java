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
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
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
/* 028 */     boolean isNull5 = i.isNullAt(5);
/* 029 */     long value5 = isNull5 ? -1L : (i.getLong(5));
/* 030 */     if (isNull5) {
/* 031 */       rowWriter.setNullAt(5);
/* 032 */     } else {
/* 033 */       rowWriter.write(5, value5);
/* 034 */     }
/* 035 */
/* 036 */   }
/* 037 */
/* 038 */
/* 039 */   private void apply_0(InternalRow i) {
/* 040 */
/* 041 */
/* 042 */     boolean isNull = i.isNullAt(0);
/* 043 */     long value = isNull ? -1L : (i.getLong(0));
/* 044 */     if (isNull) {
/* 045 */       rowWriter.setNullAt(0);
/* 046 */     } else {
/* 047 */       rowWriter.write(0, value);
/* 048 */     }
/* 049 */
/* 050 */
/* 051 */     boolean isNull1 = i.isNullAt(1);
/* 052 */     long value1 = isNull1 ? -1L : (i.getLong(1));
/* 053 */     if (isNull1) {
/* 054 */       rowWriter.setNullAt(1);
/* 055 */     } else {
/* 056 */       rowWriter.write(1, value1);
/* 057 */     }
/* 058 */
/* 059 */
/* 060 */     boolean isNull2 = i.isNullAt(2);
/* 061 */     long value2 = isNull2 ? -1L : (i.getLong(2));
/* 062 */     if (isNull2) {
/* 063 */       rowWriter.setNullAt(2);
/* 064 */     } else {
/* 065 */       rowWriter.write(2, value2);
/* 066 */     }
/* 067 */
/* 068 */
/* 069 */     boolean isNull3 = i.isNullAt(3);
/* 070 */     long value3 = isNull3 ? -1L : (i.getLong(3));
/* 071 */     if (isNull3) {
/* 072 */       rowWriter.setNullAt(3);
/* 073 */     } else {
/* 074 */       rowWriter.write(3, value3);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull4 = i.isNullAt(4);
/* 079 */     long value4 = isNull4 ? -1L : (i.getLong(4));
/* 080 */     if (isNull4) {
/* 081 */       rowWriter.setNullAt(4);
/* 082 */     } else {
/* 083 */       rowWriter.write(4, value4);
/* 084 */     }
/* 085 */
/* 086 */   }
/* 087 */
/* 088 */
/* 089 */   // Scala.Function1 need this
/* 090 */   public java.lang.Object apply(java.lang.Object row) {
/* 091 */     return apply((InternalRow) row);
/* 092 */   }
/* 093 */
/* 094 */   public UnsafeRow apply(InternalRow i) {
/* 095 */     rowWriter.zeroOutNullBytes();
/* 096 */     apply_0(i);
/* 097 */     apply_1(i);
/* 098 */     return result;
/* 099 */   }
/* 100 */ }
