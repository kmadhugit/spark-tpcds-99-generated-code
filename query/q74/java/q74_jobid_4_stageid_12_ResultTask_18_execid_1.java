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
/* 018 */   private UTF8String smj_value6;
/* 019 */   private boolean smj_isNull3;
/* 020 */   private UTF8String smj_value7;
/* 021 */   private boolean smj_isNull4;
/* 022 */   private UTF8String smj_value8;
/* 023 */   private boolean smj_isNull5;
/* 024 */   private double smj_value9;
/* 025 */   private boolean smj_isNull6;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 027 */   private UnsafeRow smj_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 030 */   private UnsafeRow project_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     smj_leftInput = inputs[0];
/* 042 */     smj_rightInput = inputs[1];
/* 043 */
/* 044 */     smj_rightRow = null;
/* 045 */
/* 046 */     smj_matches = new java.util.ArrayList();
/* 047 */
/* 048 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 049 */     smj_result = new UnsafeRow(8);
/* 050 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 160);
/* 051 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 8);
/* 052 */     project_result = new UnsafeRow(7);
/* 053 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 054 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private boolean findNextInnerJoinRows(
/* 059 */     scala.collection.Iterator leftIter,
/* 060 */     scala.collection.Iterator rightIter) {
/* 061 */     smj_leftRow = null;
/* 062 */     int comp = 0;
/* 063 */     while (smj_leftRow == null) {
/* 064 */       if (!leftIter.hasNext()) return false;
/* 065 */       smj_leftRow = (InternalRow) leftIter.next();
/* 066 */
/* 067 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 068 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 069 */       if (smj_isNull) {
/* 070 */         smj_leftRow = null;
/* 071 */         continue;
/* 072 */       }
/* 073 */       if (!smj_matches.isEmpty()) {
/* 074 */         comp = 0;
/* 075 */         if (comp == 0) {
/* 076 */           comp = smj_value.compare(smj_value3);
/* 077 */         }
/* 078 */
/* 079 */         if (comp == 0) {
/* 080 */           return true;
/* 081 */         }
/* 082 */         smj_matches.clear();
/* 083 */       }
/* 084 */
/* 085 */       do {
/* 086 */         if (smj_rightRow == null) {
/* 087 */           if (!rightIter.hasNext()) {
/* 088 */             smj_value3 = smj_value.clone();
/* 089 */             return !smj_matches.isEmpty();
/* 090 */           }
/* 091 */           smj_rightRow = (InternalRow) rightIter.next();
/* 092 */
/* 093 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 094 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 095 */           if (smj_isNull1) {
/* 096 */             smj_rightRow = null;
/* 097 */             continue;
/* 098 */           }
/* 099 */           smj_value2 = smj_value1.clone();
/* 100 */         }
/* 101 */
/* 102 */         comp = 0;
/* 103 */         if (comp == 0) {
/* 104 */           comp = smj_value.compare(smj_value2);
/* 105 */         }
/* 106 */
/* 107 */         if (comp > 0) {
/* 108 */           smj_rightRow = null;
/* 109 */         } else if (comp < 0) {
/* 110 */           if (!smj_matches.isEmpty()) {
/* 111 */             smj_value3 = smj_value.clone();
/* 112 */             return true;
/* 113 */           }
/* 114 */           smj_leftRow = null;
/* 115 */         } else {
/* 116 */           smj_matches.add(smj_rightRow.copy());
/* 117 */           smj_rightRow = null;;
/* 118 */         }
/* 119 */       } while (smj_leftRow != null);
/* 120 */     }
/* 121 */     return false; // unreachable
/* 122 */   }
/* 123 */
/* 124 */   protected void processNext() throws java.io.IOException {
/* 125 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 126 */       int smj_size = smj_matches.size();
/* 127 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 128 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 129 */       smj_value5 = smj_leftRow.getDouble(1);
/* 130 */       smj_isNull3 = smj_leftRow.isNullAt(2);
/* 131 */       smj_value6 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(2));
/* 132 */       smj_isNull4 = smj_leftRow.isNullAt(3);
/* 133 */       smj_value7 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(3));
/* 134 */       smj_isNull5 = smj_leftRow.isNullAt(4);
/* 135 */       smj_value8 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(4));
/* 136 */       smj_isNull6 = smj_leftRow.isNullAt(5);
/* 137 */       smj_value9 = smj_isNull6 ? -1.0 : (smj_leftRow.getDouble(5));
/* 138 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 139 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 140 */
/* 141 */         smj_numOutputRows.add(1);
/* 142 */
/* 143 */         double smj_value11 = smj_rightRow1.getDouble(1);
/* 144 */         project_holder.reset();
/* 145 */
/* 146 */         project_rowWriter.zeroOutNullBytes();
/* 147 */
/* 148 */         if (smj_isNull2) {
/* 149 */           project_rowWriter.setNullAt(0);
/* 150 */         } else {
/* 151 */           project_rowWriter.write(0, smj_value4);
/* 152 */         }
/* 153 */
/* 154 */         project_rowWriter.write(1, smj_value5);
/* 155 */
/* 156 */         if (smj_isNull3) {
/* 157 */           project_rowWriter.setNullAt(2);
/* 158 */         } else {
/* 159 */           project_rowWriter.write(2, smj_value6);
/* 160 */         }
/* 161 */
/* 162 */         if (smj_isNull4) {
/* 163 */           project_rowWriter.setNullAt(3);
/* 164 */         } else {
/* 165 */           project_rowWriter.write(3, smj_value7);
/* 166 */         }
/* 167 */
/* 168 */         if (smj_isNull5) {
/* 169 */           project_rowWriter.setNullAt(4);
/* 170 */         } else {
/* 171 */           project_rowWriter.write(4, smj_value8);
/* 172 */         }
/* 173 */
/* 174 */         if (smj_isNull6) {
/* 175 */           project_rowWriter.setNullAt(5);
/* 176 */         } else {
/* 177 */           project_rowWriter.write(5, smj_value9);
/* 178 */         }
/* 179 */
/* 180 */         project_rowWriter.write(6, smj_value11);
/* 181 */         project_result.setTotalSize(project_holder.totalSize());
/* 182 */         append(project_result.copy());
/* 183 */
/* 184 */       }
/* 185 */       if (shouldStop()) return;
/* 186 */     }
/* 187 */   }
/* 188 */ }
