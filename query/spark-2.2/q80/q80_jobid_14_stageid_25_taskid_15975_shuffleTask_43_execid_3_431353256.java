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
/* 028 */     boolean isNull5 = i.isNullAt(5);
/* 029 */     double value5 = isNull5 ? -1.0 : (i.getDouble(5));
/* 030 */     if (isNull5) {
/* 031 */       rowWriter.setNullAt(5);
/* 032 */     } else {
/* 033 */       rowWriter.write(5, value5);
/* 034 */     }
/* 035 */
/* 036 */
/* 037 */     boolean isNull6 = i.isNullAt(6);
/* 038 */     double value6 = isNull6 ? -1.0 : (i.getDouble(6));
/* 039 */     if (isNull6) {
/* 040 */       rowWriter.setNullAt(6);
/* 041 */     } else {
/* 042 */       rowWriter.write(6, value6);
/* 043 */     }
/* 044 */
/* 045 */
/* 046 */     boolean isNull7 = i.isNullAt(7);
/* 047 */     long value7 = isNull7 ? -1L : (i.getLong(7));
/* 048 */     if (isNull7) {
/* 049 */       rowWriter.setNullAt(7);
/* 050 */     } else {
/* 051 */       rowWriter.write(7, value7);
/* 052 */     }
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */
/* 057 */   private void apply_0(InternalRow i) {
/* 058 */
/* 059 */
/* 060 */     boolean isNull = i.isNullAt(0);
/* 061 */     double value = isNull ? -1.0 : (i.getDouble(0));
/* 062 */     if (isNull) {
/* 063 */       rowWriter.setNullAt(0);
/* 064 */     } else {
/* 065 */       rowWriter.write(0, value);
/* 066 */     }
/* 067 */
/* 068 */
/* 069 */     boolean isNull1 = i.isNullAt(1);
/* 070 */     double value1 = isNull1 ? -1.0 : (i.getDouble(1));
/* 071 */     if (isNull1) {
/* 072 */       rowWriter.setNullAt(1);
/* 073 */     } else {
/* 074 */       rowWriter.write(1, value1);
/* 075 */     }
/* 076 */
/* 077 */
/* 078 */     boolean isNull2 = i.isNullAt(2);
/* 079 */     double value2 = isNull2 ? -1.0 : (i.getDouble(2));
/* 080 */     if (isNull2) {
/* 081 */       rowWriter.setNullAt(2);
/* 082 */     } else {
/* 083 */       rowWriter.write(2, value2);
/* 084 */     }
/* 085 */
/* 086 */
/* 087 */     boolean isNull3 = i.isNullAt(3);
/* 088 */     long value3 = isNull3 ? -1L : (i.getLong(3));
/* 089 */     if (isNull3) {
/* 090 */       rowWriter.setNullAt(3);
/* 091 */     } else {
/* 092 */       rowWriter.write(3, value3);
/* 093 */     }
/* 094 */
/* 095 */
/* 096 */     boolean isNull4 = i.isNullAt(4);
/* 097 */     double value4 = isNull4 ? -1.0 : (i.getDouble(4));
/* 098 */     if (isNull4) {
/* 099 */       rowWriter.setNullAt(4);
/* 100 */     } else {
/* 101 */       rowWriter.write(4, value4);
/* 102 */     }
/* 103 */
/* 104 */   }
/* 105 */
/* 106 */
/* 107 */   // Scala.Function1 need this
/* 108 */   public java.lang.Object apply(java.lang.Object row) {
/* 109 */     return apply((InternalRow) row);
/* 110 */   }
/* 111 */
/* 112 */   public UnsafeRow apply(InternalRow i) {
/* 113 */     rowWriter.zeroOutNullBytes();
/* 114 */     apply_0(i);
/* 115 */     apply_1(i);
/* 116 */     return result;
/* 117 */   }
/* 118 */ }
