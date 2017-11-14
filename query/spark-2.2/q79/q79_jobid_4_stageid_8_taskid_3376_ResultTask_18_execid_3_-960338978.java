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
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 96);
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
/* 028 */     boolean isNull4 = i.isNullAt(4);
/* 029 */     double value4 = isNull4 ? -1.0 : (i.getDouble(4));
/* 030 */     if (isNull4) {
/* 031 */       rowWriter.setNullAt(4);
/* 032 */     } else {
/* 033 */       rowWriter.write(4, value4);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull5 = i.isNullAt(5);
/* 038 */     double value5 = isNull5 ? -1.0 : (i.getDouble(5));
/* 039 */     if (isNull5) {
/* 040 */       rowWriter.setNullAt(5);
/* 041 */     } else {
/* 042 */       rowWriter.write(5, value5);
/* 043 */     }
/* 044 */
/* 045 */   }
/* 046 */
/* 047 */
/* 048 */   private void apply_0(InternalRow i) {
/* 049 */
/* 050 */
/* 051 */     boolean isNull = i.isNullAt(0);
/* 052 */     UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 053 */     if (isNull) {
/* 054 */       rowWriter.setNullAt(0);
/* 055 */     } else {
/* 056 */       rowWriter.write(0, value);
/* 057 */     }
/* 058 */
/* 059 */
/* 060 */     boolean isNull1 = i.isNullAt(1);
/* 061 */     UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 062 */     if (isNull1) {
/* 063 */       rowWriter.setNullAt(1);
/* 064 */     } else {
/* 065 */       rowWriter.write(1, value1);
/* 066 */     }
/* 067 */
/* 068 */
/* 069 */     boolean isNull2 = i.isNullAt(2);
/* 070 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 071 */     if (isNull2) {
/* 072 */       rowWriter.setNullAt(2);
/* 073 */     } else {
/* 074 */       rowWriter.write(2, value2);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull3 = i.isNullAt(3);
/* 079 */     int value3 = isNull3 ? -1 : (i.getInt(3));
/* 080 */     if (isNull3) {
/* 081 */       rowWriter.setNullAt(3);
/* 082 */     } else {
/* 083 */       rowWriter.write(3, value3);
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
/* 095 */     holder.reset();
/* 096 */
/* 097 */     rowWriter.zeroOutNullBytes();
/* 098 */     apply_0(i);
/* 099 */     apply_1(i);
/* 100 */     result.setTotalSize(holder.totalSize());
/* 101 */     return result;
/* 102 */   }
/* 103 */ }
