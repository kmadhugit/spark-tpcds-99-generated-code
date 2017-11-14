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
/* 012 */   private int smj_value4;
/* 013 */   private int smj_value5;
/* 014 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 015 */   private int smj_value6;
/* 016 */   private int smj_value7;
/* 017 */   private int smj_value8;
/* 018 */   private boolean smj_isNull4;
/* 019 */   private int smj_value9;
/* 020 */   private boolean smj_isNull5;
/* 021 */   private int smj_value10;
/* 022 */   private boolean smj_isNull6;
/* 023 */   private double smj_value11;
/* 024 */   private boolean smj_isNull7;
/* 025 */   private double smj_value12;
/* 026 */   private boolean smj_isNull8;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 028 */   private UnsafeRow smj_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     smj_leftInput = inputs[0];
/* 040 */     smj_rightInput = inputs[1];
/* 041 */
/* 042 */     smj_rightRow = null;
/* 043 */
/* 044 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 045 */
/* 046 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 047 */     smj_result = new UnsafeRow(10);
/* 048 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 0);
/* 049 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 10);
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   private boolean findNextInnerJoinRows(
/* 054 */     scala.collection.Iterator leftIter,
/* 055 */     scala.collection.Iterator rightIter) {
/* 056 */     smj_leftRow = null;
/* 057 */     int comp = 0;
/* 058 */     while (smj_leftRow == null) {
/* 059 */       if (!leftIter.hasNext()) return false;
/* 060 */       smj_leftRow = (InternalRow) leftIter.next();
/* 061 */
/* 062 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 063 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 064 */
/* 065 */       boolean smj_isNull1 = smj_leftRow.isNullAt(0);
/* 066 */       int smj_value1 = smj_isNull1 ? -1 : (smj_leftRow.getInt(0));
/* 067 */       if (smj_isNull || smj_isNull1) {
/* 068 */         smj_leftRow = null;
/* 069 */         continue;
/* 070 */       }
/* 071 */       if (!smj_matches.isEmpty()) {
/* 072 */         comp = 0;
/* 073 */         if (comp == 0) {
/* 074 */           comp = (smj_value > smj_value6 ? 1 : smj_value < smj_value6 ? -1 : 0);
/* 075 */         }
/* 076 */         if (comp == 0) {
/* 077 */           comp = (smj_value1 > smj_value7 ? 1 : smj_value1 < smj_value7 ? -1 : 0);
/* 078 */         }
/* 079 */
/* 080 */         if (comp == 0) {
/* 081 */           return true;
/* 082 */         }
/* 083 */         smj_matches.clear();
/* 084 */       }
/* 085 */
/* 086 */       do {
/* 087 */         if (smj_rightRow == null) {
/* 088 */           if (!rightIter.hasNext()) {
/* 089 */             smj_value6 = smj_value;
/* 090 */             smj_value7 = smj_value1;
/* 091 */             return !smj_matches.isEmpty();
/* 092 */           }
/* 093 */           smj_rightRow = (InternalRow) rightIter.next();
/* 094 */
/* 095 */           boolean smj_isNull2 = smj_rightRow.isNullAt(1);
/* 096 */           int smj_value2 = smj_isNull2 ? -1 : (smj_rightRow.getInt(1));
/* 097 */
/* 098 */           boolean smj_isNull3 = smj_rightRow.isNullAt(0);
/* 099 */           int smj_value3 = smj_isNull3 ? -1 : (smj_rightRow.getInt(0));
/* 100 */           if (smj_isNull2 || smj_isNull3) {
/* 101 */             smj_rightRow = null;
/* 102 */             continue;
/* 103 */           }
/* 104 */           smj_value4 = smj_value2;
/* 105 */           smj_value5 = smj_value3;
/* 106 */         }
/* 107 */
/* 108 */         comp = 0;
/* 109 */         if (comp == 0) {
/* 110 */           comp = (smj_value > smj_value4 ? 1 : smj_value < smj_value4 ? -1 : 0);
/* 111 */         }
/* 112 */         if (comp == 0) {
/* 113 */           comp = (smj_value1 > smj_value5 ? 1 : smj_value1 < smj_value5 ? -1 : 0);
/* 114 */         }
/* 115 */
/* 116 */         if (comp > 0) {
/* 117 */           smj_rightRow = null;
/* 118 */         } else if (comp < 0) {
/* 119 */           if (!smj_matches.isEmpty()) {
/* 120 */             smj_value6 = smj_value;
/* 121 */             smj_value7 = smj_value1;
/* 122 */             return true;
/* 123 */           }
/* 124 */           smj_leftRow = null;
/* 125 */         } else {
/* 126 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 127 */           smj_rightRow = null;;
/* 128 */         }
/* 129 */       } while (smj_leftRow != null);
/* 130 */     }
/* 131 */     return false; // unreachable
/* 132 */   }
/* 133 */
/* 134 */   protected void processNext() throws java.io.IOException {
/* 135 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 136 */       smj_isNull4 = smj_leftRow.isNullAt(0);
/* 137 */       smj_value8 = smj_isNull4 ? -1 : (smj_leftRow.getInt(0));
/* 138 */       smj_isNull5 = smj_leftRow.isNullAt(1);
/* 139 */       smj_value9 = smj_isNull5 ? -1 : (smj_leftRow.getInt(1));
/* 140 */       smj_isNull6 = smj_leftRow.isNullAt(2);
/* 141 */       smj_value10 = smj_isNull6 ? -1 : (smj_leftRow.getInt(2));
/* 142 */       smj_isNull7 = smj_leftRow.isNullAt(3);
/* 143 */       smj_value11 = smj_isNull7 ? -1.0 : (smj_leftRow.getDouble(3));
/* 144 */       smj_isNull8 = smj_leftRow.isNullAt(4);
/* 145 */       smj_value12 = smj_isNull8 ? -1.0 : (smj_leftRow.getDouble(4));
/* 146 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 147 */       while (smj_iterator.hasNext()) {
/* 148 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 149 */
/* 150 */         smj_numOutputRows.add(1);
/* 151 */
/* 152 */         boolean smj_isNull9 = smj_rightRow1.isNullAt(0);
/* 153 */         int smj_value13 = smj_isNull9 ? -1 : (smj_rightRow1.getInt(0));
/* 154 */         boolean smj_isNull10 = smj_rightRow1.isNullAt(1);
/* 155 */         int smj_value14 = smj_isNull10 ? -1 : (smj_rightRow1.getInt(1));
/* 156 */         boolean smj_isNull11 = smj_rightRow1.isNullAt(2);
/* 157 */         int smj_value15 = smj_isNull11 ? -1 : (smj_rightRow1.getInt(2));
/* 158 */         boolean smj_isNull12 = smj_rightRow1.isNullAt(3);
/* 159 */         double smj_value16 = smj_isNull12 ? -1.0 : (smj_rightRow1.getDouble(3));
/* 160 */         boolean smj_isNull13 = smj_rightRow1.isNullAt(4);
/* 161 */         double smj_value17 = smj_isNull13 ? -1.0 : (smj_rightRow1.getDouble(4));
/* 162 */         smj_rowWriter.zeroOutNullBytes();
/* 163 */
/* 164 */         if (smj_isNull4) {
/* 165 */           smj_rowWriter.setNullAt(0);
/* 166 */         } else {
/* 167 */           smj_rowWriter.write(0, smj_value8);
/* 168 */         }
/* 169 */
/* 170 */         if (smj_isNull5) {
/* 171 */           smj_rowWriter.setNullAt(1);
/* 172 */         } else {
/* 173 */           smj_rowWriter.write(1, smj_value9);
/* 174 */         }
/* 175 */
/* 176 */         if (smj_isNull6) {
/* 177 */           smj_rowWriter.setNullAt(2);
/* 178 */         } else {
/* 179 */           smj_rowWriter.write(2, smj_value10);
/* 180 */         }
/* 181 */
/* 182 */         if (smj_isNull7) {
/* 183 */           smj_rowWriter.setNullAt(3);
/* 184 */         } else {
/* 185 */           smj_rowWriter.write(3, smj_value11);
/* 186 */         }
/* 187 */
/* 188 */         if (smj_isNull8) {
/* 189 */           smj_rowWriter.setNullAt(4);
/* 190 */         } else {
/* 191 */           smj_rowWriter.write(4, smj_value12);
/* 192 */         }
/* 193 */
/* 194 */         if (smj_isNull9) {
/* 195 */           smj_rowWriter.setNullAt(5);
/* 196 */         } else {
/* 197 */           smj_rowWriter.write(5, smj_value13);
/* 198 */         }
/* 199 */
/* 200 */         if (smj_isNull10) {
/* 201 */           smj_rowWriter.setNullAt(6);
/* 202 */         } else {
/* 203 */           smj_rowWriter.write(6, smj_value14);
/* 204 */         }
/* 205 */
/* 206 */         if (smj_isNull11) {
/* 207 */           smj_rowWriter.setNullAt(7);
/* 208 */         } else {
/* 209 */           smj_rowWriter.write(7, smj_value15);
/* 210 */         }
/* 211 */
/* 212 */         if (smj_isNull12) {
/* 213 */           smj_rowWriter.setNullAt(8);
/* 214 */         } else {
/* 215 */           smj_rowWriter.write(8, smj_value16);
/* 216 */         }
/* 217 */
/* 218 */         if (smj_isNull13) {
/* 219 */           smj_rowWriter.setNullAt(9);
/* 220 */         } else {
/* 221 */           smj_rowWriter.write(9, smj_value17);
/* 222 */         }
/* 223 */         append(smj_result.copy());
/* 224 */
/* 225 */       }
/* 226 */       if (shouldStop()) return;
/* 227 */     }
/* 228 */   }
/* 229 */ }
