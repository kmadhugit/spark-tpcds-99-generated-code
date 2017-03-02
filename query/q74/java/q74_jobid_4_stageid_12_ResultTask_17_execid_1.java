/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private UTF8String smj_value2;
/* 013 */   private java.util.ArrayList smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private UTF8String smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private double smj_value5;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 019 */   private UnsafeRow smj_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 022 */
/* 023 */   public GeneratedIterator(Object[] references) {
/* 024 */     this.references = references;
/* 025 */   }
/* 026 */
/* 027 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 028 */     partitionIndex = index;
/* 029 */     this.inputs = inputs;
/* 030 */     smj_leftInput = inputs[0];
/* 031 */     smj_rightInput = inputs[1];
/* 032 */
/* 033 */     smj_rightRow = null;
/* 034 */
/* 035 */     smj_matches = new java.util.ArrayList();
/* 036 */
/* 037 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 038 */     smj_result = new UnsafeRow(6);
/* 039 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 128);
/* 040 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 6);
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */   private boolean findNextInnerJoinRows(
/* 045 */     scala.collection.Iterator leftIter,
/* 046 */     scala.collection.Iterator rightIter) {
/* 047 */     smj_leftRow = null;
/* 048 */     int comp = 0;
/* 049 */     while (smj_leftRow == null) {
/* 050 */       if (!leftIter.hasNext()) return false;
/* 051 */       smj_leftRow = (InternalRow) leftIter.next();
/* 052 */
/* 053 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 054 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 055 */       if (smj_isNull) {
/* 056 */         smj_leftRow = null;
/* 057 */         continue;
/* 058 */       }
/* 059 */       if (!smj_matches.isEmpty()) {
/* 060 */         comp = 0;
/* 061 */         if (comp == 0) {
/* 062 */           comp = smj_value.compare(smj_value3);
/* 063 */         }
/* 064 */
/* 065 */         if (comp == 0) {
/* 066 */           return true;
/* 067 */         }
/* 068 */         smj_matches.clear();
/* 069 */       }
/* 070 */
/* 071 */       do {
/* 072 */         if (smj_rightRow == null) {
/* 073 */           if (!rightIter.hasNext()) {
/* 074 */             smj_value3 = smj_value.clone();
/* 075 */             return !smj_matches.isEmpty();
/* 076 */           }
/* 077 */           smj_rightRow = (InternalRow) rightIter.next();
/* 078 */
/* 079 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 080 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 081 */           if (smj_isNull1) {
/* 082 */             smj_rightRow = null;
/* 083 */             continue;
/* 084 */           }
/* 085 */           smj_value2 = smj_value1.clone();
/* 086 */         }
/* 087 */
/* 088 */         comp = 0;
/* 089 */         if (comp == 0) {
/* 090 */           comp = smj_value.compare(smj_value2);
/* 091 */         }
/* 092 */
/* 093 */         if (comp > 0) {
/* 094 */           smj_rightRow = null;
/* 095 */         } else if (comp < 0) {
/* 096 */           if (!smj_matches.isEmpty()) {
/* 097 */             smj_value3 = smj_value.clone();
/* 098 */             return true;
/* 099 */           }
/* 100 */           smj_leftRow = null;
/* 101 */         } else {
/* 102 */           smj_matches.add(smj_rightRow.copy());
/* 103 */           smj_rightRow = null;;
/* 104 */         }
/* 105 */       } while (smj_leftRow != null);
/* 106 */     }
/* 107 */     return false; // unreachable
/* 108 */   }
/* 109 */
/* 110 */   protected void processNext() throws java.io.IOException {
/* 111 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 112 */       int smj_size = smj_matches.size();
/* 113 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 114 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 115 */       smj_value5 = smj_leftRow.getDouble(1);
/* 116 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 117 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 118 */
/* 119 */         smj_numOutputRows.add(1);
/* 120 */
/* 121 */         boolean smj_isNull3 = smj_rightRow1.isNullAt(0);
/* 122 */         UTF8String smj_value6 = smj_isNull3 ? null : (smj_rightRow1.getUTF8String(0));
/* 123 */         boolean smj_isNull4 = smj_rightRow1.isNullAt(1);
/* 124 */         UTF8String smj_value7 = smj_isNull4 ? null : (smj_rightRow1.getUTF8String(1));
/* 125 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(2);
/* 126 */         UTF8String smj_value8 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(2));
/* 127 */         boolean smj_isNull6 = smj_rightRow1.isNullAt(3);
/* 128 */         double smj_value9 = smj_isNull6 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 129 */         smj_holder.reset();
/* 130 */
/* 131 */         smj_rowWriter.zeroOutNullBytes();
/* 132 */
/* 133 */         if (smj_isNull2) {
/* 134 */           smj_rowWriter.setNullAt(0);
/* 135 */         } else {
/* 136 */           smj_rowWriter.write(0, smj_value4);
/* 137 */         }
/* 138 */
/* 139 */         smj_rowWriter.write(1, smj_value5);
/* 140 */
/* 141 */         if (smj_isNull3) {
/* 142 */           smj_rowWriter.setNullAt(2);
/* 143 */         } else {
/* 144 */           smj_rowWriter.write(2, smj_value6);
/* 145 */         }
/* 146 */
/* 147 */         if (smj_isNull4) {
/* 148 */           smj_rowWriter.setNullAt(3);
/* 149 */         } else {
/* 150 */           smj_rowWriter.write(3, smj_value7);
/* 151 */         }
/* 152 */
/* 153 */         if (smj_isNull5) {
/* 154 */           smj_rowWriter.setNullAt(4);
/* 155 */         } else {
/* 156 */           smj_rowWriter.write(4, smj_value8);
/* 157 */         }
/* 158 */
/* 159 */         if (smj_isNull6) {
/* 160 */           smj_rowWriter.setNullAt(5);
/* 161 */         } else {
/* 162 */           smj_rowWriter.write(5, smj_value9);
/* 163 */         }
/* 164 */         smj_result.setTotalSize(smj_holder.totalSize());
/* 165 */         append(smj_result.copy());
/* 166 */
/* 167 */       }
/* 168 */       if (shouldStop()) return;
/* 169 */     }
/* 170 */   }
/* 171 */ }
