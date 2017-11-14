/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificMutableProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificMutableProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private boolean isNull_0;
/* 010 */   private long value_0;
/* 011 */   private boolean isNull_1;
/* 012 */   private double value_1;
/* 013 */   private boolean isNull_2;
/* 014 */   private double value_2;
/* 015 */
/* 016 */   public SpecificMutableProjection(Object[] references) {
/* 017 */     this.references = references;
/* 018 */     mutableRow = new org.apache.spark.sql.catalyst.expressions.GenericInternalRow(3);
/* 019 */     this.isNull_0 = true;
/* 020 */     this.value_0 = -1L;
/* 021 */     this.isNull_1 = true;
/* 022 */     this.value_1 = -1.0;
/* 023 */     this.isNull_2 = true;
/* 024 */     this.value_2 = -1.0;
/* 025 */
/* 026 */   }
/* 027 */
/* 028 */   public void initialize(int partitionIndex) {
/* 029 */
/* 030 */   }
/* 031 */
/* 032 */
/* 033 */   private void apply_1(InternalRow i) {
/* 034 */
/* 035 */
/* 036 */     boolean isNull9 = true;
/* 037 */     double value9 = -1.0;
/* 038 */
/* 039 */     boolean isNull11 = i.isNullAt(1);
/* 040 */     double value11 = isNull11 ? -1.0 : (i.getDouble(1));
/* 041 */     boolean isNull10 = isNull11;
/* 042 */     double value10 = value11;
/* 043 */     if (isNull10) {
/* 044 */
/* 045 */       boolean isNull12 = false;
/* 046 */       double value12 = -1.0;
/* 047 */       if (!false) {
/* 048 */         value12 = (double) 0;
/* 049 */       }
/* 050 */       if (!isNull12) {
/* 051 */         isNull10 = false;
/* 052 */         value10 = value12;
/* 053 */       }
/* 054 */     }
/* 055 */
/* 056 */     boolean isNull14 = i.isNullAt(4);
/* 057 */     double value14 = isNull14 ? -1.0 : (i.getDouble(4));
/* 058 */     if (!isNull14) {
/* 059 */
/* 060 */       isNull9 = false; // resultCode could change nullability.
/* 061 */       value9 = value10 + value14;
/* 062 */
/* 063 */     }
/* 064 */     boolean isNull8 = isNull9;
/* 065 */     double value8 = value9;
/* 066 */     if (isNull8) {
/* 067 */
/* 068 */       boolean isNull15 = i.isNullAt(1);
/* 069 */       double value15 = isNull15 ? -1.0 : (i.getDouble(1));
/* 070 */       if (!isNull15) {
/* 071 */         isNull8 = false;
/* 072 */         value8 = value15;
/* 073 */       }
/* 074 */     }
/* 075 */     this.isNull_1 = isNull8;
/* 076 */     this.value_1 = value8;
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */
/* 081 */   private void apply_0(InternalRow i) {
/* 082 */
/* 083 */
/* 084 */     boolean isNull1 = true;
/* 085 */     long value1 = -1L;
/* 086 */
/* 087 */     boolean isNull3 = i.isNullAt(0);
/* 088 */     long value3 = isNull3 ? -1L : (i.getLong(0));
/* 089 */     boolean isNull2 = isNull3;
/* 090 */     long value2 = value3;
/* 091 */     if (isNull2) {
/* 092 */
/* 093 */       boolean isNull4 = false;
/* 094 */       long value4 = -1L;
/* 095 */       if (!false) {
/* 096 */         value4 = (long) 0;
/* 097 */       }
/* 098 */       if (!isNull4) {
/* 099 */         isNull2 = false;
/* 100 */         value2 = value4;
/* 101 */       }
/* 102 */     }
/* 103 */
/* 104 */     boolean isNull6 = i.isNullAt(3);
/* 105 */     long value6 = isNull6 ? -1L : (i.getLong(3));
/* 106 */     if (!isNull6) {
/* 107 */
/* 108 */       isNull1 = false; // resultCode could change nullability.
/* 109 */       value1 = value2 + value6;
/* 110 */
/* 111 */     }
/* 112 */     boolean isNull = isNull1;
/* 113 */     long value = value1;
/* 114 */     if (isNull) {
/* 115 */
/* 116 */       boolean isNull7 = i.isNullAt(0);
/* 117 */       long value7 = isNull7 ? -1L : (i.getLong(0));
/* 118 */       if (!isNull7) {
/* 119 */         isNull = false;
/* 120 */         value = value7;
/* 121 */       }
/* 122 */     }
/* 123 */     this.isNull_0 = isNull;
/* 124 */     this.value_0 = value;
/* 125 */
/* 126 */   }
/* 127 */
/* 128 */
/* 129 */   private void apply_2(InternalRow i) {
/* 130 */
/* 131 */
/* 132 */     boolean isNull17 = true;
/* 133 */     double value17 = -1.0;
/* 134 */
/* 135 */     boolean isNull19 = i.isNullAt(2);
/* 136 */     double value19 = isNull19 ? -1.0 : (i.getDouble(2));
/* 137 */     boolean isNull18 = isNull19;
/* 138 */     double value18 = value19;
/* 139 */     if (isNull18) {
/* 140 */
/* 141 */       boolean isNull20 = false;
/* 142 */       double value20 = -1.0;
/* 143 */       if (!false) {
/* 144 */         value20 = (double) 0;
/* 145 */       }
/* 146 */       if (!isNull20) {
/* 147 */         isNull18 = false;
/* 148 */         value18 = value20;
/* 149 */       }
/* 150 */     }
/* 151 */
/* 152 */     boolean isNull22 = i.isNullAt(5);
/* 153 */     double value22 = isNull22 ? -1.0 : (i.getDouble(5));
/* 154 */     if (!isNull22) {
/* 155 */
/* 156 */       isNull17 = false; // resultCode could change nullability.
/* 157 */       value17 = value18 + value22;
/* 158 */
/* 159 */     }
/* 160 */     boolean isNull16 = isNull17;
/* 161 */     double value16 = value17;
/* 162 */     if (isNull16) {
/* 163 */
/* 164 */       boolean isNull23 = i.isNullAt(2);
/* 165 */       double value23 = isNull23 ? -1.0 : (i.getDouble(2));
/* 166 */       if (!isNull23) {
/* 167 */         isNull16 = false;
/* 168 */         value16 = value23;
/* 169 */       }
/* 170 */     }
/* 171 */     this.isNull_2 = isNull16;
/* 172 */     this.value_2 = value16;
/* 173 */
/* 174 */   }
/* 175 */
/* 176 */
/* 177 */   public org.apache.spark.sql.catalyst.expressions.codegen.BaseMutableProjection target(InternalRow row) {
/* 178 */     mutableRow = row;
/* 179 */     return this;
/* 180 */   }
/* 181 */
/* 182 */   /* Provide immutable access to the last projected row. */
/* 183 */   public InternalRow currentValue() {
/* 184 */     return (InternalRow) mutableRow;
/* 185 */   }
/* 186 */
/* 187 */   public java.lang.Object apply(java.lang.Object _i) {
/* 188 */     InternalRow i = (InternalRow) _i;
/* 189 */
/* 190 */     apply_0(i);
/* 191 */     apply_1(i);
/* 192 */     apply_2(i);
/* 193 */     // copy all the results into MutableRow
/* 194 */
/* 195 */     if (!this.isNull_0) {
/* 196 */       mutableRow.setLong(0, this.value_0);
/* 197 */     } else {
/* 198 */       mutableRow.setNullAt(0);
/* 199 */     }
/* 200 */
/* 201 */     if (!this.isNull_1) {
/* 202 */       mutableRow.setDouble(1, this.value_1);
/* 203 */     } else {
/* 204 */       mutableRow.setNullAt(1);
/* 205 */     }
/* 206 */
/* 207 */     if (!this.isNull_2) {
/* 208 */       mutableRow.setDouble(2, this.value_2);
/* 209 */     } else {
/* 210 */       mutableRow.setNullAt(2);
/* 211 */     }
/* 212 */
/* 213 */     return mutableRow;
/* 214 */   }
/* 215 */ }
