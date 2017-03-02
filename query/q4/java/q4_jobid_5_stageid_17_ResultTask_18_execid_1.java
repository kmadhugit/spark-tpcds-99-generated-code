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
/* 024 */   private UTF8String smj_value9;
/* 025 */   private boolean smj_isNull6;
/* 026 */   private UTF8String smj_value10;
/* 027 */   private boolean smj_isNull7;
/* 028 */   private UTF8String smj_value11;
/* 029 */   private boolean smj_isNull8;
/* 030 */   private UTF8String smj_value12;
/* 031 */   private boolean smj_isNull9;
/* 032 */   private double smj_value13;
/* 033 */   private boolean smj_isNull10;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 035 */   private UnsafeRow smj_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 038 */   private UnsafeRow project_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 041 */
/* 042 */   public GeneratedIterator(Object[] references) {
/* 043 */     this.references = references;
/* 044 */   }
/* 045 */
/* 046 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 047 */     partitionIndex = index;
/* 048 */     this.inputs = inputs;
/* 049 */     smj_leftInput = inputs[0];
/* 050 */     smj_rightInput = inputs[1];
/* 051 */
/* 052 */     smj_rightRow = null;
/* 053 */
/* 054 */     smj_matches = new java.util.ArrayList();
/* 055 */
/* 056 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 057 */     smj_result = new UnsafeRow(12);
/* 058 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 288);
/* 059 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 060 */     project_result = new UnsafeRow(11);
/* 061 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 256);
/* 062 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 11);
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private boolean findNextInnerJoinRows(
/* 067 */     scala.collection.Iterator leftIter,
/* 068 */     scala.collection.Iterator rightIter) {
/* 069 */     smj_leftRow = null;
/* 070 */     int comp = 0;
/* 071 */     while (smj_leftRow == null) {
/* 072 */       if (!leftIter.hasNext()) return false;
/* 073 */       smj_leftRow = (InternalRow) leftIter.next();
/* 074 */
/* 075 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 076 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 077 */       if (smj_isNull) {
/* 078 */         smj_leftRow = null;
/* 079 */         continue;
/* 080 */       }
/* 081 */       if (!smj_matches.isEmpty()) {
/* 082 */         comp = 0;
/* 083 */         if (comp == 0) {
/* 084 */           comp = smj_value.compare(smj_value3);
/* 085 */         }
/* 086 */
/* 087 */         if (comp == 0) {
/* 088 */           return true;
/* 089 */         }
/* 090 */         smj_matches.clear();
/* 091 */       }
/* 092 */
/* 093 */       do {
/* 094 */         if (smj_rightRow == null) {
/* 095 */           if (!rightIter.hasNext()) {
/* 096 */             smj_value3 = smj_value.clone();
/* 097 */             return !smj_matches.isEmpty();
/* 098 */           }
/* 099 */           smj_rightRow = (InternalRow) rightIter.next();
/* 100 */
/* 101 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 102 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 103 */           if (smj_isNull1) {
/* 104 */             smj_rightRow = null;
/* 105 */             continue;
/* 106 */           }
/* 107 */           smj_value2 = smj_value1.clone();
/* 108 */         }
/* 109 */
/* 110 */         comp = 0;
/* 111 */         if (comp == 0) {
/* 112 */           comp = smj_value.compare(smj_value2);
/* 113 */         }
/* 114 */
/* 115 */         if (comp > 0) {
/* 116 */           smj_rightRow = null;
/* 117 */         } else if (comp < 0) {
/* 118 */           if (!smj_matches.isEmpty()) {
/* 119 */             smj_value3 = smj_value.clone();
/* 120 */             return true;
/* 121 */           }
/* 122 */           smj_leftRow = null;
/* 123 */         } else {
/* 124 */           smj_matches.add(smj_rightRow.copy());
/* 125 */           smj_rightRow = null;;
/* 126 */         }
/* 127 */       } while (smj_leftRow != null);
/* 128 */     }
/* 129 */     return false; // unreachable
/* 130 */   }
/* 131 */
/* 132 */   protected void processNext() throws java.io.IOException {
/* 133 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 134 */       int smj_size = smj_matches.size();
/* 135 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 136 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 137 */       smj_value5 = smj_leftRow.getDouble(1);
/* 138 */       smj_isNull3 = smj_leftRow.isNullAt(2);
/* 139 */       smj_value6 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(2));
/* 140 */       smj_isNull4 = smj_leftRow.isNullAt(3);
/* 141 */       smj_value7 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(3));
/* 142 */       smj_isNull5 = smj_leftRow.isNullAt(4);
/* 143 */       smj_value8 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(4));
/* 144 */       smj_isNull6 = smj_leftRow.isNullAt(5);
/* 145 */       smj_value9 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(5));
/* 146 */       smj_isNull7 = smj_leftRow.isNullAt(6);
/* 147 */       smj_value10 = smj_isNull7 ? null : (smj_leftRow.getUTF8String(6));
/* 148 */       smj_isNull8 = smj_leftRow.isNullAt(7);
/* 149 */       smj_value11 = smj_isNull8 ? null : (smj_leftRow.getUTF8String(7));
/* 150 */       smj_isNull9 = smj_leftRow.isNullAt(8);
/* 151 */       smj_value12 = smj_isNull9 ? null : (smj_leftRow.getUTF8String(8));
/* 152 */       smj_isNull10 = smj_leftRow.isNullAt(9);
/* 153 */       smj_value13 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(9));
/* 154 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 155 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 156 */
/* 157 */         smj_numOutputRows.add(1);
/* 158 */
/* 159 */         double smj_value15 = smj_rightRow1.getDouble(1);
/* 160 */         project_holder.reset();
/* 161 */
/* 162 */         project_rowWriter.zeroOutNullBytes();
/* 163 */
/* 164 */         if (smj_isNull2) {
/* 165 */           project_rowWriter.setNullAt(0);
/* 166 */         } else {
/* 167 */           project_rowWriter.write(0, smj_value4);
/* 168 */         }
/* 169 */
/* 170 */         project_rowWriter.write(1, smj_value5);
/* 171 */
/* 172 */         if (smj_isNull3) {
/* 173 */           project_rowWriter.setNullAt(2);
/* 174 */         } else {
/* 175 */           project_rowWriter.write(2, smj_value6);
/* 176 */         }
/* 177 */
/* 178 */         if (smj_isNull4) {
/* 179 */           project_rowWriter.setNullAt(3);
/* 180 */         } else {
/* 181 */           project_rowWriter.write(3, smj_value7);
/* 182 */         }
/* 183 */
/* 184 */         if (smj_isNull5) {
/* 185 */           project_rowWriter.setNullAt(4);
/* 186 */         } else {
/* 187 */           project_rowWriter.write(4, smj_value8);
/* 188 */         }
/* 189 */
/* 190 */         if (smj_isNull6) {
/* 191 */           project_rowWriter.setNullAt(5);
/* 192 */         } else {
/* 193 */           project_rowWriter.write(5, smj_value9);
/* 194 */         }
/* 195 */
/* 196 */         if (smj_isNull7) {
/* 197 */           project_rowWriter.setNullAt(6);
/* 198 */         } else {
/* 199 */           project_rowWriter.write(6, smj_value10);
/* 200 */         }
/* 201 */
/* 202 */         if (smj_isNull8) {
/* 203 */           project_rowWriter.setNullAt(7);
/* 204 */         } else {
/* 205 */           project_rowWriter.write(7, smj_value11);
/* 206 */         }
/* 207 */
/* 208 */         if (smj_isNull9) {
/* 209 */           project_rowWriter.setNullAt(8);
/* 210 */         } else {
/* 211 */           project_rowWriter.write(8, smj_value12);
/* 212 */         }
/* 213 */
/* 214 */         if (smj_isNull10) {
/* 215 */           project_rowWriter.setNullAt(9);
/* 216 */         } else {
/* 217 */           project_rowWriter.write(9, smj_value13);
/* 218 */         }
/* 219 */
/* 220 */         project_rowWriter.write(10, smj_value15);
/* 221 */         project_result.setTotalSize(project_holder.totalSize());
/* 222 */         append(project_result.copy());
/* 223 */
/* 224 */       }
/* 225 */       if (shouldStop()) return;
/* 226 */     }
/* 227 */   }
/* 228 */ }
