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
/* 014 */     result = new UnsafeRow(8);
/* 015 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 0);
/* 016 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 8);
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
/* 028 */     rowWriter.write(7, 0L);
/* 029 */
/* 030 */   }
/* 031 */
/* 032 */
/* 033 */   private void apply_0(InternalRow i) {
/* 034 */
/* 035 */
/* 036 */     boolean isNull = false;
/* 037 */     double value = -1.0;
/* 038 */     if (!false) {
/* 039 */       value = (double) 0;
/* 040 */     }
/* 041 */     if (isNull) {
/* 042 */       rowWriter.setNullAt(0);
/* 043 */     } else {
/* 044 */       rowWriter.write(0, value);
/* 045 */     }
/* 046 */
/* 047 */
/* 048 */     rowWriter.write(1, 0L);
/* 049 */
/* 050 */
/* 051 */     boolean isNull3 = false;
/* 052 */     double value3 = -1.0;
/* 053 */     if (!false) {
/* 054 */       value3 = (double) 0;
/* 055 */     }
/* 056 */     if (isNull3) {
/* 057 */       rowWriter.setNullAt(2);
/* 058 */     } else {
/* 059 */       rowWriter.write(2, value3);
/* 060 */     }
/* 061 */
/* 062 */
/* 063 */     rowWriter.write(3, 0L);
/* 064 */
/* 065 */
/* 066 */     boolean isNull6 = false;
/* 067 */     double value6 = -1.0;
/* 068 */     if (!false) {
/* 069 */       value6 = (double) 0;
/* 070 */     }
/* 071 */     if (isNull6) {
/* 072 */       rowWriter.setNullAt(4);
/* 073 */     } else {
/* 074 */       rowWriter.write(4, value6);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     rowWriter.write(5, 0L);
/* 079 */
/* 080 */
/* 081 */     boolean isNull9 = false;
/* 082 */     double value9 = -1.0;
/* 083 */     if (!false) {
/* 084 */       value9 = (double) 0;
/* 085 */     }
/* 086 */     if (isNull9) {
/* 087 */       rowWriter.setNullAt(6);
/* 088 */     } else {
/* 089 */       rowWriter.write(6, value9);
/* 090 */     }
/* 091 */
/* 092 */   }
/* 093 */
/* 094 */
/* 095 */   // Scala.Function1 need this
/* 096 */   public java.lang.Object apply(java.lang.Object row) {
/* 097 */     return apply((InternalRow) row);
/* 098 */   }
/* 099 */
/* 100 */   public UnsafeRow apply(InternalRow i) {
/* 101 */     rowWriter.zeroOutNullBytes();
/* 102 */     apply_0(i);
/* 103 */     apply_1(i);
/* 104 */     return result;
/* 105 */   }
/* 106 */ }
