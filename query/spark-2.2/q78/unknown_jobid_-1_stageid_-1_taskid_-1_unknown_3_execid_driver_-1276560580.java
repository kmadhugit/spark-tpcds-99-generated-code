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
/* 012 */   private int smj_value6;
/* 013 */   private int smj_value7;
/* 014 */   private int smj_value8;
/* 015 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 016 */   private int smj_value9;
/* 017 */   private int smj_value10;
/* 018 */   private int smj_value11;
/* 019 */   private int smj_value12;
/* 020 */   private boolean smj_isNull6;
/* 021 */   private int smj_value13;
/* 022 */   private boolean smj_isNull7;
/* 023 */   private int smj_value14;
/* 024 */   private boolean smj_isNull8;
/* 025 */   private long smj_value15;
/* 026 */   private boolean smj_isNull9;
/* 027 */   private double smj_value16;
/* 028 */   private boolean smj_isNull10;
/* 029 */   private double smj_value17;
/* 030 */   private boolean smj_isNull11;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 032 */   private UnsafeRow smj_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */
/* 039 */   public GeneratedIterator(Object[] references) {
/* 040 */     this.references = references;
/* 041 */   }
/* 042 */
/* 043 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 044 */     partitionIndex = index;
/* 045 */     this.inputs = inputs;
/* 046 */     smj_leftInput = inputs[0];
/* 047 */     smj_rightInput = inputs[1];
/* 048 */
/* 049 */     smj_rightRow = null;
/* 050 */
/* 051 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 052 */
/* 053 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 054 */     smj_result = new UnsafeRow(12);
/* 055 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 056 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 12);
/* 057 */     project_result = new UnsafeRow(9);
/* 058 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 059 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 9);
/* 060 */
/* 061 */   }
/* 062 */
/* 063 */   private boolean findNextInnerJoinRows(
/* 064 */     scala.collection.Iterator leftIter,
/* 065 */     scala.collection.Iterator rightIter) {
/* 066 */     smj_leftRow = null;
/* 067 */     int comp = 0;
/* 068 */     while (smj_leftRow == null) {
/* 069 */       if (!leftIter.hasNext()) return false;
/* 070 */       smj_leftRow = (InternalRow) leftIter.next();
/* 071 */
/* 072 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 073 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(0));
/* 074 */
/* 075 */       boolean smj_isNull1 = smj_leftRow.isNullAt(1);
/* 076 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(1));
/* 077 */
/* 078 */       boolean smj_isNull2 = smj_leftRow.isNullAt(2);
/* 079 */       int smj_value2 = smj_isNull2 ? -1 : (smj_leftRow.getInt(2));
/* 080 */       if (smj_isNull || smj_isNull1 || smj_isNull2) {
/* 081 */         smj_leftRow = null;
/* 082 */         continue;
/* 083 */       }
/* 084 */       if (!smj_matches.isEmpty()) {
/* 085 */         comp = 0;
/* 086 */         if (comp == 0) {
/* 087 */           comp = (smj_value > smj_value9 ? 1 : smj_value < smj_value9 ? -1 : 0);
/* 088 */         }
/* 089 */         if (comp == 0) {
/* 090 */           comp = (smj_value1 > smj_value10 ? 1 : smj_value1 < smj_value10 ? -1 : 0);
/* 091 */         }
/* 092 */         if (comp == 0) {
/* 093 */           comp = (smj_value2 > smj_value11 ? 1 : smj_value2 < smj_value11 ? -1 : 0);
/* 094 */         }
/* 095 */
/* 096 */         if (comp == 0) {
/* 097 */           return true;
/* 098 */         }
/* 099 */         smj_matches.clear();
/* 100 */       }
/* 101 */
/* 102 */       do {
/* 103 */         if (smj_rightRow == null) {
/* 104 */           if (!rightIter.hasNext()) {
/* 105 */             smj_value9 = smj_value;
/* 106 */             smj_value10 = smj_value1;
/* 107 */             smj_value11 = smj_value2;
/* 108 */             return !smj_matches.isEmpty();
/* 109 */           }
/* 110 */           smj_rightRow = (InternalRow) rightIter.next();
/* 111 */
/* 112 */           boolean smj_isNull3 = smj_rightRow.isNullAt(0);
/* 113 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(0));
/* 114 */
/* 115 */           boolean smj_isNull4 = smj_rightRow.isNullAt(1);
/* 116 */           int smj_value4 = smj_isNull4 ? -1 : (smj_rightRow.getInt(1));
/* 117 */
/* 118 */           boolean smj_isNull5 = smj_rightRow.isNullAt(2);
/* 119 */           int smj_value5 = smj_isNull5 ? -1 : (smj_rightRow.getInt(2));
/* 120 */           if (smj_isNull3 || smj_isNull4 || smj_isNull5) {
/* 121 */             smj_rightRow = null;
/* 122 */             continue;
/* 123 */           }
/* 124 */           smj_value6 = smj_value3;
/* 125 */           smj_value7 = smj_value4;
/* 126 */           smj_value8 = smj_value5;
/* 127 */         }
/* 128 */
/* 129 */         comp = 0;
/* 130 */         if (comp == 0) {
/* 131 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 132 */         }
/* 133 */         if (comp == 0) {
/* 134 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 135 */         }
/* 136 */         if (comp == 0) {
/* 137 */           comp = (smj_value2 > smj_value8 ? 1 : smj_value2 < smj_value8 ? -1 : 0);
/* 138 */         }
/* 139 */
/* 140 */         if (comp > 0) {
/* 141 */           smj_rightRow = null;
/* 142 */         } else if (comp < 0) {
/* 143 */           if (!smj_matches.isEmpty()) {
/* 144 */             smj_value9 = smj_value;
/* 145 */             smj_value10 = smj_value1;
/* 146 */             smj_value11 = smj_value2;
/* 147 */             return true;
/* 148 */           }
/* 149 */           smj_leftRow = null;
/* 150 */         } else {
/* 151 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 152 */           smj_rightRow = null;;
/* 153 */         }
/* 154 */       } while (smj_leftRow != null);
/* 155 */     }
/* 156 */     return false; // unreachable
/* 157 */   }
/* 158 */
/* 159 */   protected void processNext() throws java.io.IOException {
/* 160 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 161 */       smj_isNull6 = smj_leftRow.isNullAt(0);
/* 162 */       smj_value12 = smj_isNull6 ? -1 : (smj_leftRow.getInt(0));
/* 163 */       smj_isNull7 = smj_leftRow.isNullAt(1);
/* 164 */       smj_value13 = smj_isNull7 ? -1 : (smj_leftRow.getInt(1));
/* 165 */       smj_isNull8 = smj_leftRow.isNullAt(2);
/* 166 */       smj_value14 = smj_isNull8 ? -1 : (smj_leftRow.getInt(2));
/* 167 */       smj_isNull9 = smj_leftRow.isNullAt(3);
/* 168 */       smj_value15 = smj_isNull9 ? -1L : (smj_leftRow.getLong(3));
/* 169 */       smj_isNull10 = smj_leftRow.isNullAt(4);
/* 170 */       smj_value16 = smj_isNull10 ? -1.0 : (smj_leftRow.getDouble(4));
/* 171 */       smj_isNull11 = smj_leftRow.isNullAt(5);
/* 172 */       smj_value17 = smj_isNull11 ? -1.0 : (smj_leftRow.getDouble(5));
/* 173 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 174 */       while (smj_iterator.hasNext()) {
/* 175 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 176 */
/* 177 */         smj_numOutputRows.add(1);
/* 178 */
/* 179 */         boolean smj_isNull15 = smj_rightRow1.isNullAt(3);
/* 180 */         long smj_value21 = smj_isNull15 ? -1L : (smj_rightRow1.getLong(3));
/* 181 */         boolean smj_isNull16 = smj_rightRow1.isNullAt(4);
/* 182 */         double smj_value22 = smj_isNull16 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 183 */         boolean smj_isNull17 = smj_rightRow1.isNullAt(5);
/* 184 */         double smj_value23 = smj_isNull17 ? -1.0 : (smj_rightRow1.getDouble(5));
/* 185 */         project_rowWriter.zeroOutNullBytes();
/* 186 */
/* 187 */         if (smj_isNull6) {
/* 188 */           project_rowWriter.setNullAt(0);
/* 189 */         } else {
/* 190 */           project_rowWriter.write(0, smj_value12);
/* 191 */         }
/* 192 */
/* 193 */         if (smj_isNull7) {
/* 194 */           project_rowWriter.setNullAt(1);
/* 195 */         } else {
/* 196 */           project_rowWriter.write(1, smj_value13);
/* 197 */         }
/* 198 */
/* 199 */         if (smj_isNull8) {
/* 200 */           project_rowWriter.setNullAt(2);
/* 201 */         } else {
/* 202 */           project_rowWriter.write(2, smj_value14);
/* 203 */         }
/* 204 */
/* 205 */         if (smj_isNull9) {
/* 206 */           project_rowWriter.setNullAt(3);
/* 207 */         } else {
/* 208 */           project_rowWriter.write(3, smj_value15);
/* 209 */         }
/* 210 */
/* 211 */         if (smj_isNull10) {
/* 212 */           project_rowWriter.setNullAt(4);
/* 213 */         } else {
/* 214 */           project_rowWriter.write(4, smj_value16);
/* 215 */         }
/* 216 */
/* 217 */         if (smj_isNull11) {
/* 218 */           project_rowWriter.setNullAt(5);
/* 219 */         } else {
/* 220 */           project_rowWriter.write(5, smj_value17);
/* 221 */         }
/* 222 */
/* 223 */         if (smj_isNull15) {
/* 224 */           project_rowWriter.setNullAt(6);
/* 225 */         } else {
/* 226 */           project_rowWriter.write(6, smj_value21);
/* 227 */         }
/* 228 */
/* 229 */         if (smj_isNull16) {
/* 230 */           project_rowWriter.setNullAt(7);
/* 231 */         } else {
/* 232 */           project_rowWriter.write(7, smj_value22);
/* 233 */         }
/* 234 */
/* 235 */         if (smj_isNull17) {
/* 236 */           project_rowWriter.setNullAt(8);
/* 237 */         } else {
/* 238 */           project_rowWriter.write(8, smj_value23);
/* 239 */         }
/* 240 */         append(project_result.copy());
/* 241 */
/* 242 */       }
/* 243 */       if (shouldStop()) return;
/* 244 */     }
/* 245 */   }
/* 246 */ }
