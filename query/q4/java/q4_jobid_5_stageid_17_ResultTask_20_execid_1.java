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
/* 017 */   private UTF8String smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private UTF8String smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private UTF8String smj_value7;
/* 022 */   private boolean smj_isNull5;
/* 023 */   private UTF8String smj_value8;
/* 024 */   private boolean smj_isNull6;
/* 025 */   private UTF8String smj_value9;
/* 026 */   private boolean smj_isNull7;
/* 027 */   private UTF8String smj_value10;
/* 028 */   private boolean smj_isNull8;
/* 029 */   private UTF8String smj_value11;
/* 030 */   private boolean smj_isNull9;
/* 031 */   private double smj_value12;
/* 032 */   private boolean smj_isNull10;
/* 033 */   private double smj_value13;
/* 034 */   private boolean smj_isNull11;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 036 */   private UnsafeRow smj_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 039 */   private UnsafeRow project_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 042 */
/* 043 */   public GeneratedIterator(Object[] references) {
/* 044 */     this.references = references;
/* 045 */   }
/* 046 */
/* 047 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 048 */     partitionIndex = index;
/* 049 */     this.inputs = inputs;
/* 050 */     smj_leftInput = inputs[0];
/* 051 */     smj_rightInput = inputs[1];
/* 052 */
/* 053 */     smj_rightRow = null;
/* 054 */
/* 055 */     smj_matches = new java.util.ArrayList();
/* 056 */
/* 057 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 058 */     smj_result = new UnsafeRow(12);
/* 059 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 288);
/* 060 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 061 */     project_result = new UnsafeRow(11);
/* 062 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 256);
/* 063 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 11);
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private boolean findNextInnerJoinRows(
/* 068 */     scala.collection.Iterator leftIter,
/* 069 */     scala.collection.Iterator rightIter) {
/* 070 */     smj_leftRow = null;
/* 071 */     int comp = 0;
/* 072 */     while (smj_leftRow == null) {
/* 073 */       if (!leftIter.hasNext()) return false;
/* 074 */       smj_leftRow = (InternalRow) leftIter.next();
/* 075 */
/* 076 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 077 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 078 */       if (smj_isNull) {
/* 079 */         smj_leftRow = null;
/* 080 */         continue;
/* 081 */       }
/* 082 */       if (!smj_matches.isEmpty()) {
/* 083 */         comp = 0;
/* 084 */         if (comp == 0) {
/* 085 */           comp = smj_value.compare(smj_value3);
/* 086 */         }
/* 087 */
/* 088 */         if (comp == 0) {
/* 089 */           return true;
/* 090 */         }
/* 091 */         smj_matches.clear();
/* 092 */       }
/* 093 */
/* 094 */       do {
/* 095 */         if (smj_rightRow == null) {
/* 096 */           if (!rightIter.hasNext()) {
/* 097 */             smj_value3 = smj_value.clone();
/* 098 */             return !smj_matches.isEmpty();
/* 099 */           }
/* 100 */           smj_rightRow = (InternalRow) rightIter.next();
/* 101 */
/* 102 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 103 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 104 */           if (smj_isNull1) {
/* 105 */             smj_rightRow = null;
/* 106 */             continue;
/* 107 */           }
/* 108 */           smj_value2 = smj_value1.clone();
/* 109 */         }
/* 110 */
/* 111 */         comp = 0;
/* 112 */         if (comp == 0) {
/* 113 */           comp = smj_value.compare(smj_value2);
/* 114 */         }
/* 115 */
/* 116 */         if (comp > 0) {
/* 117 */           smj_rightRow = null;
/* 118 */         } else if (comp < 0) {
/* 119 */           if (!smj_matches.isEmpty()) {
/* 120 */             smj_value3 = smj_value.clone();
/* 121 */             return true;
/* 122 */           }
/* 123 */           smj_leftRow = null;
/* 124 */         } else {
/* 125 */           smj_matches.add(smj_rightRow.copy());
/* 126 */           smj_rightRow = null;;
/* 127 */         }
/* 128 */       } while (smj_leftRow != null);
/* 129 */     }
/* 130 */     return false; // unreachable
/* 131 */   }
/* 132 */
/* 133 */   protected void processNext() throws java.io.IOException {
/* 134 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 135 */       int smj_size = smj_matches.size();
/* 136 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 137 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 138 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 139 */       smj_value5 = smj_isNull3 ? null : (smj_leftRow.getUTF8String(1));
/* 140 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 141 */       smj_value6 = smj_isNull4 ? null : (smj_leftRow.getUTF8String(2));
/* 142 */       smj_isNull5 = smj_leftRow.isNullAt(3);
/* 143 */       smj_value7 = smj_isNull5 ? null : (smj_leftRow.getUTF8String(3));
/* 144 */       smj_isNull6 = smj_leftRow.isNullAt(4);
/* 145 */       smj_value8 = smj_isNull6 ? null : (smj_leftRow.getUTF8String(4));
/* 146 */       smj_isNull7 = smj_leftRow.isNullAt(5);
/* 147 */       smj_value9 = smj_isNull7 ? null : (smj_leftRow.getUTF8String(5));
/* 148 */       smj_isNull8 = smj_leftRow.isNullAt(6);
/* 149 */       smj_value10 = smj_isNull8 ? null : (smj_leftRow.getUTF8String(6));
/* 150 */       smj_isNull9 = smj_leftRow.isNullAt(7);
/* 151 */       smj_value11 = smj_isNull9 ? null : (smj_leftRow.getUTF8String(7));
/* 152 */       smj_isNull10 = smj_leftRow.isNullAt(8);
/* 153 */       smj_value12 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(8));
/* 154 */       smj_isNull11 = smj_leftRow.isNullAt(9);
/* 155 */       smj_value13 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(9));
/* 156 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 157 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 158 */
/* 159 */         smj_numOutputRows.add(1);
/* 160 */
/* 161 */         double smj_value15 = smj_rightRow1.getDouble(1);
/* 162 */         project_holder.reset();
/* 163 */
/* 164 */         project_rowWriter.zeroOutNullBytes();
/* 165 */
/* 166 */         if (smj_isNull2) {
/* 167 */           project_rowWriter.setNullAt(0);
/* 168 */         } else {
/* 169 */           project_rowWriter.write(0, smj_value4);
/* 170 */         }
/* 171 */
/* 172 */         if (smj_isNull3) {
/* 173 */           project_rowWriter.setNullAt(1);
/* 174 */         } else {
/* 175 */           project_rowWriter.write(1, smj_value5);
/* 176 */         }
/* 177 */
/* 178 */         if (smj_isNull4) {
/* 179 */           project_rowWriter.setNullAt(2);
/* 180 */         } else {
/* 181 */           project_rowWriter.write(2, smj_value6);
/* 182 */         }
/* 183 */
/* 184 */         if (smj_isNull5) {
/* 185 */           project_rowWriter.setNullAt(3);
/* 186 */         } else {
/* 187 */           project_rowWriter.write(3, smj_value7);
/* 188 */         }
/* 189 */
/* 190 */         if (smj_isNull6) {
/* 191 */           project_rowWriter.setNullAt(4);
/* 192 */         } else {
/* 193 */           project_rowWriter.write(4, smj_value8);
/* 194 */         }
/* 195 */
/* 196 */         if (smj_isNull7) {
/* 197 */           project_rowWriter.setNullAt(5);
/* 198 */         } else {
/* 199 */           project_rowWriter.write(5, smj_value9);
/* 200 */         }
/* 201 */
/* 202 */         if (smj_isNull8) {
/* 203 */           project_rowWriter.setNullAt(6);
/* 204 */         } else {
/* 205 */           project_rowWriter.write(6, smj_value10);
/* 206 */         }
/* 207 */
/* 208 */         if (smj_isNull9) {
/* 209 */           project_rowWriter.setNullAt(7);
/* 210 */         } else {
/* 211 */           project_rowWriter.write(7, smj_value11);
/* 212 */         }
/* 213 */
/* 214 */         if (smj_isNull10) {
/* 215 */           project_rowWriter.setNullAt(8);
/* 216 */         } else {
/* 217 */           project_rowWriter.write(8, smj_value12);
/* 218 */         }
/* 219 */
/* 220 */         if (smj_isNull11) {
/* 221 */           project_rowWriter.setNullAt(9);
/* 222 */         } else {
/* 223 */           project_rowWriter.write(9, smj_value13);
/* 224 */         }
/* 225 */
/* 226 */         project_rowWriter.write(10, smj_value15);
/* 227 */         project_result.setTotalSize(project_holder.totalSize());
/* 228 */         append(project_result.copy());
/* 229 */
/* 230 */       }
/* 231 */       if (shouldStop()) return;
/* 232 */     }
/* 233 */   }
/* 234 */ }
